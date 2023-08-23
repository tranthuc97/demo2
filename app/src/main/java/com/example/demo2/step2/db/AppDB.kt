package com.example.demo2.step2.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Step::class, Weight::class, BMI::class], version = 1)
abstract class AppDB : RoomDatabase(){
    abstract fun getStepDAO(): StepDAO       //tạo PT trả về interface DAO, có thể gọi đến các PT của interface
}