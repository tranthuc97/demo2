package com.example.demo2.step2.db

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Handler
import android.util.Log
import com.example.demo2.App
import com.example.demo2.BaseAct
import com.example.demo2.databinding.Activity3Binding
import com.example.demo2.step2.CommonUtils
import com.example.demo2.step2.Constant
import com.example.demo2.step2.StepActivity
import com.example.demo2.step2.StepDetector
import com.example.demo2.step2.StepListener

import java.util.*


class StepActivity : BaseAct<Activity3Binding>(), SensorEventListener {
    override fun initViewBinding(): Activity3Binding {
        return Activity3Binding.inflate(layoutInflater)
    }

    companion object {
        var TAG = StepActivity::class.java.name
    }

    var stepDetector: StepDetector? = null
    var sensorManager: SensorManager? = null
    var accelerator: Sensor? = null
    var numSteps = 0
    var countStep = 0
    var count = 0
    var countMax = 0
    var th: Thread? = null
    var step = Step()


    @SuppressLint("SetTextI18n")
    override fun initViews() {
        requestPermission()

        val c = Calendar.getInstance()

        val hour = c.get(Calendar.HOUR)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val year = c.get(Calendar.YEAR)
        step.stepCounter = 0
        step.timeStep = 0
        step.hourOfDay = hour
        step.dayOfYear = day
        step.year = year


        // Get an instance of the SensorManager
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerator = sensorManager!!.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
        //stepDetector = StepDetector()
        //stepDetector!!.registerListener(this)

        binding!!.btnStart.setOnClickListener {
            sensorManager!!.registerListener(
                this, accelerator,
                SensorManager.SENSOR_DELAY_FASTEST
            )

        }

        binding!!.btnStop.setOnClickListener {
            sensorManager!!.unregisterListener(this)
        }


        //time.scheduleAtFixedRate(object : TimerTask() {
        //            override fun run() {
        //                binding!!.tvTime.text = "$count"
        //                count++
        //            }
        //        }, 1000, 1000)
       stepCount()

    }

    private fun stepCount() {
        if(countMax != 0){
            countMax+=1
        }
        if (th == null || !th!!.isAlive) {
            th = Thread {
                for (i in count..countMax) {
                    Thread.sleep(530)
                    runOnUiThread {
                        kotlin.run {
                            binding!!.tvTime.text = "time: ${(i)}"
                            count = i

                            countMax = count + 1
                        }
                    }
                }
            }
            Log.i(TAG, "thời gian max: $countMax")
            th!!.isDaemon = true
            th!!.start()
        }

        if (countStep != numSteps) {
            countStep = numSteps
            Log.i(TAG, "time1 chạy")
        }
        Handler().postDelayed({
            if (countStep == numSteps) {
                Log.i(TAG, "time1 dừng")
                countMax = count
            }
        }, 2000)


    }


    @SuppressLint("InlinedApi")
    private fun requestPermission() {
        if (checkSelfPermission(android.Manifest.permission.ACTIVITY_RECOGNITION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                arrayOf(
                    android.Manifest.permission.ACTIVITY_RECOGNITION
                ), 105
            )
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            Log.i(TAG, "event.timestamp: ${event.timestamp}")
            stepDetector!!.updateAccel(
                event.timestamp, event.values[0], event.values[1], event.values[2]
            )
        }
        numSteps++
        binding!!.tvSteps.text = "Number of Steps: $numSteps"

        stepCount()
    }

}