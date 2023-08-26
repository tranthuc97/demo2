package com.example.demo2.step2.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Weight")
class Weight {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var weight: Int? = null
    var dayOfYear: Float? = null
    var year: Int? = null

}