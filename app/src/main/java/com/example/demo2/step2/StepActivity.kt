package com.example.demo2.step2

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
import com.example.demo2.step2.db.BMI
import com.example.demo2.step2.db.Info
import com.example.demo2.step2.db.Step
import com.example.demo2.step2.db.Weight
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
    var countMax = 0
    var th: Thread? = null


    @SuppressLint("SetTextI18n")
    override fun initViews() {
        requestPermission()

        // Get an instance of the SensorManager
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerator = sensorManager!!.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
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


        //time.scheduleAtFixedRate(object : TimerTask() {
        //            override fun run() {
        //                binding!!.tvTime.text = "$count"
        //                count++
        //            }
        //        }, 1000, 1000)
        if(countMax != 0){
            countMax+=1
        }
        if (th == null || !th!!.isAlive) {
            th = Thread {
                for (i in count..countMax) {
                    Thread.sleep(700)
                    runOnUiThread {
                        kotlin.run {
                            binding!!.tvTime.text = "time: ${(i)}"
                            count = i

                            countMax = count + 1
                        }
                    }
                }
            }
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
        Log.i(TAG, "check  đếm bước: $numSteps")
        Log.i(TAG, "check  đếm thời gian: $count")
        Thread{
            CommonUtils.INSTANCE.savePrefs(Constant.TIME, count.toString())
            CommonUtils.INSTANCE.savePrefs(Constant.STEP, numSteps.toString())
            Log.i(TAG, "check  đếm thời gian lưu: ${CommonUtils.INSTANCE.getPrefs(Constant.TIME)}")
            Log.i(TAG, "check  đếm bước lưu: ${CommonUtils.INSTANCE.getPrefs(Constant.STEP)}")
        }.start()

        CommonUtils.INSTANCE.savePrefs(Constant.CALORIE, (numSteps.toFloat() * 0.06F).toString())
        CommonUtils.INSTANCE.savePrefs(Constant.METER, (numSteps.toFloat() * 0.5F).toString())

        binding!!.btCheck.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            var info = Info()
            var step = Step()
            var weight = Weight()
            var chiSoBMI = BMI()
//            step.id = 1

            info.age = CommonUtils.INSTANCE.getPrefs(Constant.AGE)!!.toInt()
            info.name = CommonUtils.INSTANCE.getPrefs(Constant.NAME)
            info.sex = CommonUtils.INSTANCE.getPrefs(Constant.SEX)

            step.day = day
            step.week = day / 7
            step.month = month
            step.year = year
            step.step = CommonUtils.INSTANCE.getPrefs(Constant.STEP)!!.toInt()
            step.time = CommonUtils.INSTANCE.getPrefs(Constant.TIME)!!.toInt()
            step.calorie = CommonUtils.INSTANCE.getPrefs(Constant.CALORIE)!!.toFloat()
            step.meter = CommonUtils.INSTANCE.getPrefs(Constant.METER)!!.toFloat()
            step.stepTarget = CommonUtils.INSTANCE.getPrefs(Constant.STEPTARGET)!!.toInt()

            weight.height = CommonUtils.INSTANCE.getPrefs(Constant.HEIGHT)!!.toInt()
            weight.weight = CommonUtils.INSTANCE.getPrefs(Constant.WEIGHT)!!.toInt()
            weight.targetWeight = CommonUtils.INSTANCE.getPrefs(Constant.TARGETWEIGHT)!!.toInt()
            weight.weightPound = CommonUtils.INSTANCE.getPrefs(Constant.WEIGHT)!!.toFloat() * 0.45F
            weight.heightFeet = CommonUtils.INSTANCE.getPrefs(Constant.HEIGHT)!!.toFloat() * 3.28F

            chiSoBMI.BMI = CommonUtils.INSTANCE.getPrefs(Constant.BMI)!!.toFloat()


            Thread {
                App.INSTANCE.DB.getStepDAO().insertStep(step)
                App.INSTANCE.DB.getStepDAO().insertBMI(chiSoBMI)
                App.INSTANCE.DB.getStepDAO().insertWeight(weight)
                App.INSTANCE.DB.getStepDAO().insertInfo(info)
            }.start()
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

        initViews()
    }


    @SuppressLint("SetTextI18n")
    override fun step(timeNs: Long) {

        //binding!!.tvTime.text = (timeNs / 1000000000L).toString()
        //
        //binding!!.tvTime.text = ((System.currentTimeMillis() + ((timeNs-SystemClock.elapsedRealtimeNanos())/1000000L))/1000L).toString()

    }

}