package com.example.demo2.step2.db.model

class DistanceHour(var distance:Float, var hour:Int){
    override fun toString(): String {
        return "$distance:$hour"
    }
}