package com.example.demo2.step2.db

import android.util.Log
import com.example.demo2.App
import com.example.demo2.BaseAct
import com.example.demo2.databinding.Activity4Binding

class ActivityDB : BaseAct<Activity4Binding>() {
    override fun initViewBinding(): Activity4Binding {
        return Activity4Binding.inflate(layoutInflater)
    }

    override fun initViews() {
        var hour = 0
        var step = 100
        var timeStep = 10
        var day = 10
        var year = 2023
        var stepDB = Step()

        Thread {
            for(i in 0..23){
                hour += i
                stepDB.stepCounter = step
                stepDB.hourOfDay = hour
                stepDB.dayOfYear = day
                stepDB.year = year
                stepDB.timeStep = timeStep
                App.instance.db.getStepDAO().insertStepHour(stepDB)
            }
        }.start()

        var listStep:ArrayList<Int> = arrayListOf()


        //Log.i("TAG", "ds bước chân theo giờ trong ngày: ${App.instance.db.getStepDAO().getListStepHour(day, year)}")
    }
}