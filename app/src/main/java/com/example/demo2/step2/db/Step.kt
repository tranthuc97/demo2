package com.example.demo2.step2.db

import android.annotation.SuppressLint
import androidx.room.AutoMigration
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import io.reactivex.annotations.NonNull
import org.jetbrains.annotations.NotNull


@Entity(tableName = "Step")
class Step {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var hourOfDay: Int? = null
    var stepCounter: Int? = null
    var timeStep: Int? = null
    var dayOfYear: Int? = null
    var year: Int? = null

}