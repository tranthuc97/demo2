package com.example.demo2

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.SystemClock
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.demo2.databinding.Activity3Binding
import com.google.type.DateTime
import org.joda.time.DateTimeZone
import java.util.concurrent.TimeUnit


class SensorStep : BaseAct<Activity3Binding>(), SensorEventListener {
    companion object {
        var TAG = SensorStep::class.java.name
    }

    lateinit var sensorManager: SensorManager
    lateinit var step_sensor: Sensor

    override fun initViewBinding(): Activity3Binding {
        return Activity3Binding.inflate(layoutInflater)
    }


    override fun initViews() {
        requestSMSPermission()      //ACTIVITY_RECOGNITION permissions

        sensorManager =
            applicationContext?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        step_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!!
        sensorManager.registerListener(
            this, step_sensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )

    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun requestSMSPermission() {
        if (checkSelfPermission(android.Manifest.permission.ACTIVITY_RECOGNITION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                arrayOf(
                    android.Manifest.permission.ACTIVITY_RECOGNITION
                ), 105
            )
        }
    }


    override fun onSensorChanged(event: SensorEvent?) {
        Log.i(TAG, "đếm số bước chân: ${event?.values!![0]}")
        //Log.i(TAG, "đếm số thời gian: $millis")
        val systemCurrentTimeMillis = System.currentTimeMillis()
        val systemClockElapsedRealtimeMillis = TimeUnit.NANOSECONDS.toMillis(SystemClock.elapsedRealtimeNanos())
        val sensorEventTimeStampMillis = TimeUnit.NANOSECONDS.toMillis(event.timestamp)
        val currentMinusElapsedRealtimeMillis = systemCurrentTimeMillis - systemClockElapsedRealtimeMillis
        val actualEventTimeMillis = currentMinusElapsedRealtimeMillis + sensorEventTimeStampMillis
        val actualEventTimeUtc = org.joda.time.DateTime(actualEventTimeMillis, DateTimeZone.UTC)  //implementation 'net.danlew:android.joda:2.12.5'

        binding!!.tvStep.text = event.values!![0].toString()
        binding!!.tvTime.text = actualEventTimeUtc.toString()
    }




    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //do nothing
    }

    override fun onResume() {
        super.onResume()
        step_sensor?.also { light ->
            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL)
        }       //đky lại cảm biến
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)      //hủy đky cảm biến, tránh tốn pin
    }
}