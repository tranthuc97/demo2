package com.example.demo2

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.demo2.databinding.Activity3Binding


class SensorStep : BaseAct<Activity3Binding>() {
    companion object {
        var TAG = SensorStep::class.java.name
    }
     var mBroadcast:Broadcast? = null


    override fun initViewBinding(): Activity3Binding {
        return Activity3Binding.inflate(layoutInflater)
    }


    override fun initViews() {
        requestSMSPermission()      //ACTIVITY_RECOGNITION permissions

        var intent = Intent(this,StepService::class.java)
        startService(intent)

        mBroadcast = Broadcast()
        val filter = IntentFilter("test.Broadcast")
        registerReceiver(mBroadcast, filter)

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


    //override fun onResume() {
    //        super.onResume()
    //        step_sensor?.also { light ->
    //            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL)
    //        }       //đky lại cảm biến
    //    }
    //
    //    override fun onPause() {
    //        super.onPause()
    //        sensorManager.unregisterListener(this)      //hủy đky cảm biến, tránh tốn pin
    //    }
}