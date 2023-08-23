package com.example.demo2

import android.app.Application
import androidx.room.Room
import com.example.demo2.step2.db.AppDB


class App : Application() {

    private var db: AppDB? = null
    val DB: AppDB
        get() = db!!

    companion object {
        private var instance:App? = null
        val INSTANCE:App
            get() = instance!!
    }
    lateinit var storage:Storage

    override fun onCreate() {
        super.onCreate()
        instance = this
        storage = Storage()

        //khởi tạo 1 CSDL lưu trong data bộ nhớ
        db = Room.databaseBuilder(
            this,
            AppDB::class.java, "step-db")
            .allowMainThreadQueries()
            .build()    //khởi tạo database để có thể truy vấn ở tất cả mọi nơi trong project
    }
}