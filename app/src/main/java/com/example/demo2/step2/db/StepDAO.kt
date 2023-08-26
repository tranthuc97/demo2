package com.example.demo2.step2.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface StepDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStepHour(step: Step)      //add stepHour

  //  @Insert(onConflict = OnConflictStrategy.REPLACE)
    //    fun insertWeightDay(weight: Weight)     //add weightDay

//    @Query("SELECT Step.stepCounter FROM Step WHERE Step.dayOfYear = :day AND Step.year =:year")
//    fun getListStepHour(day:Int, year:Int):ArrayList<Int>     //get list step per Hour of dayOfYear and year
//
//    @Query("SELECT Step.timeStep FROM Step WHERE Step.dayOfYear = :day AND Step.year =:year")
//    fun getListTimeHour(day:Int, year:Int)      //get list timeStep per Hour of dayOfYear and year
//
//    @Query("SELECT SUM(Step.stepCounter) FROM Step WHERE Step.dayOfYear = :day AND Step.year =:year")
//    fun getStepDay(day:Int, year:Int):Int         //get step per dayOfYear and year
//
//    @Query("SELECT SUM(Step.timeStep) FROM Step WHERE Step.dayOfYear = :day AND Step.year =:year")
//    fun getTimeStepDay(day:Int, year:Int):Int         //get step per dayOfYear and year
//        @Query("SELECT Weight.weight FROM Weight WHERE Weight.dayOfYear =:day AND Weight.year =:year")
//    fun getWeightDay(day:Int, year:Int):Int     //get weightDay




    @Update
    fun update(step: Step)


    @Delete
    fun delete(step: Step)
}