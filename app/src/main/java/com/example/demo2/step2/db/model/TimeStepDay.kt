package com.example.demo2.step2.db.model

class TimeStepDay(var time:Int, var day:Int, var year:Int){
    override fun toString(): String {
        return "$time:$day:$year"
    }
}