package com.example.demo2.step2.db

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Handler
import android.util.Log
import com.example.demo2.BaseAct
import com.example.demo2.databinding.Activity3Binding
import com.example.demo2.step2.StepActivity
import com.example.demo2.step2.StepDetector
import com.example.demo2.step2.db.model.*
import java.util.*
import kotlin.collections.ArrayList


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
    var th: Thread? = Thread()
    var step = Step()
    var hourNow = 0
    var listStepHour:ArrayList<StepHour> = arrayListOf()
    var listTimeStepHour:ArrayList<TimeHour> = arrayListOf()
    var listStepDay:ArrayList<StepDay> = arrayListOf()
    var listTimeStepDay:ArrayList<TimeStepDay> = arrayListOf()
    var dayStart = 0
    var dayEnd = 0
    var yearCurrent = 0
    var dayInput = 0




    @SuppressLint("SetTextI18n")
    override fun initViews() {
        requestPermission()

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerator = sensorManager!!.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)

        binding!!.btnStart.setOnClickListener {
            sensorManager!!.registerListener(
                this, accelerator,
                SensorManager.SENSOR_DELAY_FASTEST
            )

        }

        binding!!.btnStop.setOnClickListener {
            sensorManager!!.unregisterListener(this)
        }

        stepCount()
    }

    private fun stepCount() {
        runtime()

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
        val c = Calendar.getInstance()  //update time liên tục mỗi khi nhận cảm biến bước đi
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val day = c.get(Calendar.DAY_OF_YEAR)
        val year = c.get(Calendar.YEAR)
        step.stepCounter = numSteps

        step.hourOfDay = hour
        step.dayOfYear = day
        step.year = year

        Log.i(TAG, "so sánh giờ hiện tại và giờ tham chiếu $hour and $hourNow")
        if (hour != hourNow) {
            numSteps = 0
                count = 0

            runtime()   //reset time và numsteps
            hourNow = hour
            StepDataSource.insertStepHour(step)
        } else {
            StepDataSource.updateStepHour(numSteps, countMax, hour)
        }

        //in log
        dayStart = 235
        dayEnd = 240
        yearCurrent = 2023
        dayInput = 235
        listStepHour = StepDataSource.getListStepPerHour(dayInput,yearCurrent)
        listTimeStepHour = StepDataSource.getListTimePerHour(dayInput,yearCurrent)
        Log.i(TAG, "list step ngày $dayInput: ${listStepHour.toString()}")
        Log.i(TAG, "list tg đi bộ ngày $dayInput: ${listTimeStepHour.toString()}")

        //trả về ds bước chân và thời gian đi bộ theo khoảng ngày
        listStepDay = StepDataSource.getListStepDay(dayStart, dayEnd, yearCurrent)
        listTimeStepDay = StepDataSource.getListTimeStepDay(dayStart, dayEnd, yearCurrent)
        Log.i(TAG, "list bước chân từ $dayStart - $dayEnd ${listStepDay.toString()}")
        Log.i(TAG, "list tg đi bộ từ $dayStart - $dayEnd: ${listTimeStepDay.toString()}")

        var weight = Weight()
        weight.weight = 60
        for (i in 235..240){
            weight.dayOfYear = i
            weight.weight = weight.weight!! + 1
            weight.year = yearCurrent
            StepDataSource.insertWeight(weight)
        }

        StepDataSource.updateWeightDay(100, 280, yearCurrent)
        var listWeight:ArrayList<WeightDay> = arrayListOf()
        listWeight = StepDataSource.getListWeightDay(235, 240, yearCurrent)
        Log.i(TAG, "danh sách cân nặng theo ngày: $listWeight")
    }

    private fun runtime() {
        if (countMax != 0) {
            countMax += 1
        }
        if (th == null || !th!!.isAlive) {
            th = Thread {
                var i = 0
                do {
                    Thread.sleep(550)
                    runOnUiThread {
                        kotlin.run {
                            i = count
                            Log.i(TAG, "time đếm được: $i")
                            binding!!.tvTime.text = "time: ${(i)}"
                            i++
                            count = i
                            countMax = count + 1
                        }
                    }
                }while (i<countMax)
            }
            step.timeStep = countMax
            th!!.isDaemon = true
            th!!.start()
        }
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