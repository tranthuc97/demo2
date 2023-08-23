package com.example.demo2.step2.db

import android.annotation.SuppressLint
import androidx.room.AutoMigration
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import io.reactivex.annotations.NonNull
import org.jetbrains.annotations.NotNull


@Entity(tableName = "stepDB")
class Step {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var name: String? = null
    var age: Int? = null
    var step: Int? = null
    var time: Int? = null
    var calorie: Float? = null
    var meter: Float? = null
    var height: Int? = null
    var targetWeight: Int? = null




    override fun toString(): String {
        return name.toString()
    }
}