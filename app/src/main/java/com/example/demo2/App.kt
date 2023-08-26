package com.example.demo2

import android.app.Application
import androidx.room.Room
import com.example.demo2.step2.db.AppDB


class App : Application() {

    lateinit var db: AppDB

    companion object {
        lateinit var instance: App
    }

    lateinit var storage: Storage

    override fun onCreate() {
        super.onCreate()
        instance = this
        storage = Storage()

        //khởi tạo 1 CSDL lưu trong data bộ nhớ
        db = Room.databaseBuilder(
            this,
            AppDB::class.java, "step-db"
        )
            .allowMainThreadQueries()
            .build()    //khởi tạo database để có thể truy vấn ở tất cả mọi nơi trong project
    }
}