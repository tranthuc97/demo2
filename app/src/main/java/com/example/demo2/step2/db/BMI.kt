package com.example.demo2.step2.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BMI")
class BMI {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var BMI: Float? = null
}