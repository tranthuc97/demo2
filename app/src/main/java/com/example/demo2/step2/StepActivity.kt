package com.example.demo2.step2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.demo2.BaseAct
import com.example.demo2.databinding.Activity3Binding
import com.example.demo2.databinding.ActivityBmiBinding
import java.util.*


class StepActivity : BaseAct<Activity3Binding>(), SensorEventListener, StepListener {
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
    var countMax = 1
    var th:Thread? = null
    var BMI:Float? = null


    @SuppressLint("SetTextI18n")
    override fun initViews() {
        requestPermission()

        // Get an instance of the SensorManager
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerator = sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        stepDetector = StepDetector()
        stepDetector!!.registerListener(this)

        binding!!.btnStart.setOnClickListener {
            sensorManager!!.registerListener(
                this, accelerator,
                SensorManager.SENSOR_DELAY_FASTEST
            )

        }

        binding!!.btnStop.setOnClickListener {
            sensorManager!!.unregisterListener(this)
        }

        binding!!.btnToBMI.setOnClickListener{
            var intent = Intent(this, BMIActivity()::class.java)
            startActivity(intent)
        }


        //time.scheduleAtFixedRate(object : TimerTask() {
        //            override fun run() {
        //                binding!!.tvTime.text = "$count"
        //                count++
        //            }
        //        }, 1000, 1000)
        countMax++
        if (th == null || !th!!.isAlive) {
                    th = Thread {
                        for (i in count..countMax) {
                            Thread.sleep(800)
                            runOnUiThread {
                                kotlin.run {
                                   binding!!.tvTime.text = "time: ${(i-2).toString()}"
                                    count = i
                                    countMax = count+1
                                }
                            }
                        }
                    }
                    th!!.isDaemon = true
                    th!!.start()
                }

        if(countStep != numSteps) {
            countStep = numSteps
            Log.i(TAG, "time1 chạy")

        }
        Handler().postDelayed({
            if(countStep == numSteps){
                Log.i(TAG, "time1 dừng")
                countMax = count
            }
        },5000)

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

    }



    @SuppressLint("SetTextI18n")
    override fun step(timeNs: Long) {
        numSteps++
        binding!!.tvSteps.text = "Number of Steps: $numSteps"
        //binding!!.tvTime.text = (timeNs / 1000000000L).toString()
        //
        //binding!!.tvTime.text = ((System.currentTimeMillis() + ((timeNs-SystemClock.elapsedRealtimeNanos())/1000000L))/1000L).toString()
        initViews()
    }

}