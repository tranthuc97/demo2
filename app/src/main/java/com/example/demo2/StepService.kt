package com.example.demo2

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import org.joda.time.DateTimeZone
import java.util.concurrent.TimeUnit

class StepService : android.app.Service(), SensorEventListener {

    lateinit var sensorManager: SensorManager
    lateinit var step_sensor: Sensor
    companion object {
         val STEP: String = "STEP"
         val TIME: String = "TIME"
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        startStep()
    }

    private fun startStep() {
        sensorManager =
            applicationContext?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        step_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!!
        sensorManager.registerListener(
            this, step_sensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onSensorChanged(event: SensorEvent?) {
        Log.i(SensorStep.TAG, "đếm số bước chân: ${event?.values!![0]}")
        //Log.i(TAG, "đếm số thời gian: $millis")
        val systemCurrentTimeMillis = System.currentTimeMillis()
        val systemClockElapsedRealtimeMillis = TimeUnit.NANOSECONDS.toMillis(SystemClock.elapsedRealtimeNanos())
        val sensorEventTimeStampMillis = TimeUnit.NANOSECONDS.toMillis(event.timestamp)
        val currentMinusElapsedRealtimeMillis = systemCurrentTimeMillis - systemClockElapsedRealtimeMillis
        val actualEventTimeMillis = currentMinusElapsedRealtimeMillis + sensorEventTimeStampMillis
        val actualEventTimeUtc = org.joda.time.DateTime(actualEventTimeMillis, DateTimeZone.UTC)  //implementation 'net.danlew:android.joda:2.12.5'

        //binding!!.tvStep.text = event.values!![0].toString()
        //binding!!.tvTime.text = actualEventTimeUtc.toString()
        val intent = Intent()
        var bundle = Bundle()
        bundle.putString(STEP, event?.values!![0].toString())
        bundle.putString(TIME, actualEventTimeUtc.toString())
        intent.putExtras(bundle)
        intent.action = "send.Broadcast"
        sendBroadcast(intent)

    }




    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //do nothing
    }


}