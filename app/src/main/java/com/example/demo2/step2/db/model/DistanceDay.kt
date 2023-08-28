package com.example.demo2.step2.db.model

class DistanceDay(var distance:Float, var day:Int, var year:Int){
    override fun toString(): String {
        return "$distance:$day:$year"
    }
}