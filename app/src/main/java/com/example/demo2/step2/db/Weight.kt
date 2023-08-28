package com.example.demo2.step2.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.reactivex.annotations.NonNull

@Entity(tableName = "Weight")
class Weight {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 0

    var weight: Int? = null
    var dayOfYear: Int? = null
    var year: Int? = null

}