package com.example.demo2.step2.db

import androidx.room.*
import com.example.demo2.step2.db.model.StepHour


@Dao
interface StepDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStepHour(step: Step)      //add stepHour

    @Query("UPDATE Step SET stepCounter = :step, timeStep = :time WHERE hourOfDay = :hour")
    fun updateStepHour(step: Int?, time: Int?, hour: Int?)

    @Query("SELECT Step.stepCounter FROM Step WHERE hourOfDay =:hour AND dayOfYear = :day AND year =:year")
    fun getListStepHour(
        hour: Int,
        day: Int,
        year: Int
    ): Int   //get list step per Hour of dayOfYear and year

    @Query("SELECT Step.timeStep FROM Step WHERE hourOfDay =:hour AND dayOfYear = :day AND year =:year")
    fun getListTimeStepHour(
        hour: Int,
        day: Int,
        year: Int
    ): Int     //get list timeStep per Hour of dayOfYear and year

    @Query("SELECT SUM(Step.stepCounter) FROM Step WHERE dayOfYear = :day AND year =:year")
    fun getStepDay(day:Int, year:Int):Int         //get step per dayOfYear and year

    @Query("SELECT SUM(Step.timeStep) FROM Step WHERE dayOfYear = :day AND year =:year")
    fun getTimeStepDay(day:Int, year:Int):Int         //get timeStep per dayOfYear and year

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeight(weight: Weight)      //add stepHour

    @Query("UPDATE Weight SET weight = :weight WHERE dayOfYear = :day AND year =:year")
    fun updateWeight(weight: Int?, day: Int?, year:Int?)

    @Query("SELECT Weight.weight FROM Weight WHERE dayOfYear = :day AND year =:year")
    fun getWeightPerDay(
        day: Int,
        year: Int
    ): Int     //get weight per day

    @Update
    fun update(step: Step)

    @Delete
    fun delete(step: Step)
}


