package com.example.demo2.step2.db.model

class CalorieHour(var calo:Float, var hour:Int){
    override fun toString(): String {
        return "$calo:$hour"
    }
}