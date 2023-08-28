package com.example.demo2.step2.db.model

class StepDay(var step:Int, var day:Int, var year:Int){
    override fun toString(): String {
        return "$step:$day:$year"
    }
}