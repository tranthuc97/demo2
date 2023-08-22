package com.example.demo2.step2

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.health.connect.TimeRangeFilter
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.demo2.BaseAct
import com.example.demo2.databinding.Activity3Binding
import java.lang.Thread.sleep
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.TimeUnit


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
    lateinit var timeReal:Timer
    var count = 0
    var countStep = 0
    var countStep2 = 0
    lateinit var thread:Thread

    override fun initViews() {
        requestPermission()





        // Get an instance of the SensorManager
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerator = sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        stepDetector = StepDetector()
        stepDetector!!.registerListener(this)



        binding!!.btnStart.setOnClickListener {
            //numSteps = 0
            sensorManager!!.registerListener(
                this, accelerator,
                SensorManager.SENSOR_DELAY_FASTEST
            )
            //startTime()

        }

        binding!!.btnStop.setOnClickListener {
            sensorManager!!.unregisterListener(this)
        }



        Handler().postDelayed({
            if(countStep != numSteps){
                countStep = numSteps
                timeReal.cancel()
                timeReal = Timer()
                timeReal.scheduleAtFixedRate(object : TimerTask() {
                    override fun run() {
                        runOnUiThread {
                            binding!!.tvTime.text = count.toString()
                            count++
                        }
                    }
                }, 1000, 1000)
            }else{
                timeReal.cancel()
                timeReal = Timer()
                timeReal.scheduleAtFixedRate(object : TimerTask() {
                    override fun run() {
                        runOnUiThread {
                            binding!!.tvTime.text = count.toString()
                            count = count
                        }
                    }
                }, 1000, 1000)
            }
        },5000)

    }

    private fun startTime() {
        timeReal = Timer()
        timeReal.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    binding!!.tvTime.text = count.toString()
                    count++
                }
            }
        }, 1000, 1000)
    }


    private fun changeTime() {

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
        //initViews()

    }
}