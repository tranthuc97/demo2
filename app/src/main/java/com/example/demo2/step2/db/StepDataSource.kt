package com.example.demo2.step2.db

import com.example.demo2.App
import com.example.demo2.step2.db.model.*

object StepDataSource{
    fun insertStepHour(step:Step){
        App.instance.db.getStepDAO().insertStepHour(step)   //nhập số liệu step theo giờ
    }

    fun updateStepHour(step:Int, time: Int, hour:Int){
        App.instance.db.getStepDAO().updateStepHour(step, time, hour)   //update step & time theo giờ tham chiếu
    }

    fun getStepHour(hour:Int, day:Int, year:Int):Int{
        return App.instance.db.getStepDAO().getListStepHour(hour, day, year)  //lấy danh sách step theo ngày(thuộc năm...)
    }

    fun getTimeStepHour(hour:Int, day:Int, year:Int):Int{
        return App.instance.db.getStepDAO().getListTimeStepHour(hour, day, year)  //lấy danh sách time đi bộ theo ngày(thuộc năm...)
    }

    fun getListStepPerHour(dayInput:Int, yearInput:Int):ArrayList<StepHour>{
        val listStepHour:ArrayList<StepHour> = arrayListOf()
        for(j in 0..24){
            val stepHour = getStepHour(j, dayInput, yearInput)
            listStepHour.add(StepHour(stepHour, j))
        }
        return listStepHour     //trả về ds số bước chân theo giờ trong ngày đã nhập
    }

    fun getListTimePerHour(dayInput:Int, yearInput:Int):ArrayList<TimeHour>{
        val listTimeStepHour:ArrayList<TimeHour> = arrayListOf()
        for(j in 0..24){
            val timeHour = getTimeStepHour(j, dayInput, yearInput)
            listTimeStepHour.add(TimeHour(timeHour, j))
        }
        return listTimeStepHour     //trả về ds thời gian đi bộ theo giờ trong ngày đã nhập
    }

    fun getListCaloPerHour(caloPerStep:Float, dayInput:Int, yearInput:Int):ArrayList<CalorieHour>{
        val listCaloHour:ArrayList<CalorieHour> = arrayListOf()
        for(j in 0..24){
            val caloHour = getStepHour(j, dayInput, yearInput).toFloat() * caloPerStep
            listCaloHour.add(CalorieHour(caloHour, j))
        }
        return listCaloHour     //trả về ds số calo tiêu thụ theo giờ trong ngày đã nhập
    }

    fun getListDistancePerHour(distancePreStep:Float, dayInput:Int, yearInput:Int):ArrayList<DistanceHour>{
        val listDistanceHour:ArrayList<DistanceHour> = arrayListOf()
        for(j in 0..24){
            val distanceHour = getStepHour(j, dayInput, yearInput).toFloat() * distancePreStep
            listDistanceHour.add(DistanceHour(distanceHour, j))
        }
        return listDistanceHour     //trả về ds quãng đường đi được theo giờ trong ngày đã nhập
    }

    fun getStepDay(day:Int, year: Int):Int{
        return App.instance.db.getStepDAO().getStepDay(day, year)       //lấy tổng số bước chân trong ngày đã nhập
    }

    fun getTimeStepDay(day:Int, year: Int):Int{
        return App.instance.db.getStepDAO().getTimeStepDay(day, year)       //lấy tổng số thời gian đi bộ trong ngày đã nhập
    }

    fun getListStepDay(dayStart:Int, dayEnd:Int, yearInput:Int):ArrayList<StepDay>{
        val listStepDay:ArrayList<StepDay> = arrayListOf()
        for(i in dayStart..dayEnd){
            val stepDay = getStepDay(i, yearInput)
            listStepDay.add(StepDay(stepDay, i, yearInput))
        }
        return listStepDay      //trả về ds số bước chân mỗi ngày theo khoảng ngày(thuộc năm) đã nhập
    }

    fun getListTimeStepDay(dayStart:Int, dayEnd:Int, yearInput:Int):ArrayList<TimeStepDay>{
        val listTimeStepDay:ArrayList<TimeStepDay> = arrayListOf()
        for(i in dayStart..dayEnd){
            val timeDay = StepDataSource.getTimeStepDay(i, yearInput)
            listTimeStepDay.add(TimeStepDay(timeDay, i, yearInput))
        }
        return listTimeStepDay      //trả về ds thời gian đi bộ mỗi ngày theo khoảng ngày(thuộc năm) đã nhập
    }

    fun getListCaloDay(caloPerStep:Float, dayStart:Int, dayEnd:Int, yearInput:Int):ArrayList<CalorieDay>{
        val listCaloDay:ArrayList<CalorieDay> = arrayListOf()
        for(i in dayStart..dayEnd){
            val caloDay = getStepDay(i, yearInput).toFloat() * caloPerStep
            listCaloDay.add(CalorieDay(caloDay, i, yearInput))
        }
        return listCaloDay      //trả về ds calo tiêu thụ mỗi ngày theo khoảng ngày(thuộc năm) đã nhập
    }

    fun getListDistanceDay(distancePreStep:Float, dayStart:Int, dayEnd:Int, yearInput:Int):ArrayList<DistanceDay>{
        val listStepDay:ArrayList<DistanceDay> = arrayListOf()
        for(i in dayStart..dayEnd){
            val distanceDay = getStepDay(i, yearInput).toFloat() * distancePreStep
            listStepDay.add(DistanceDay(distanceDay, i, yearInput))
        }
        return listStepDay      //trả về quãng đường di chuyển mỗi ngày theo khoảng ngày(thuộc năm) đã nhập
    }

    fun insertWeight(weight: Weight){
        App.instance.db.getStepDAO().insertWeight(weight)   //nhập số liệu step theo giờ
    }

    fun updateWeightDay(weight: Int, dayInput:Int, yearInput:Int){
        App.instance.db.getStepDAO().updateWeight(weight, dayInput, yearInput)   //update step & time theo giờ tham chiếu
    }

    fun getWeightDay(day:Int, year: Int):Int{
        return App.instance.db.getStepDAO().getWeightPerDay(day, year)       //lấy cân nặng theo ngày
    }

    fun getListWeightDay(dayStart:Int, dayEnd:Int, yearInput:Int):ArrayList<WeightDay>{
        val listWeightDay:ArrayList<WeightDay> = arrayListOf()
        for(i in dayStart..dayEnd){
            val weightDay = getWeightDay(i, yearInput)
            listWeightDay.add(WeightDay(weightDay, i, yearInput))
        }
        return listWeightDay      //trả về ds cân nặng theo khoảng ngày(thuộc năm) đã nhập
    }



}