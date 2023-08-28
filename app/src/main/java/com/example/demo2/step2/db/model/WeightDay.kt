package com.example.demo2.step2.db.model

class WeightDay(var weight:Int, var day:Int, var year:Int){
    override fun toString(): String {
        return "$weight:$day:$year"
    }
}