package com.example.demo2.step2.db.model

class TimeHour(var hour:Int, var time:Int){
    override fun toString(): String {
        return "$hour:$time"
    }
}