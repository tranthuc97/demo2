package com.example.demo2.step2.db.model

class CalorieDay(var calo:Float, var day:Int, var year:Int){
    override fun toString(): String {
        return "$calo:$Float:$year"
    }
}