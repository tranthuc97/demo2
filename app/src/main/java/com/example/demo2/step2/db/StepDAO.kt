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
    fun insertStep(step: Step)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeight(weight: Weight)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBMI(step: BMI)



    @Update
    fun update(step: Step)

    @Delete
    fun delete(step: Step)
}