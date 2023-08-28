package com.example.demo2.step2.db.model

class StepHour(var step:Int, var hour:Int){
    override fun toString(): String {
        return "$step:$hour"
    }
}