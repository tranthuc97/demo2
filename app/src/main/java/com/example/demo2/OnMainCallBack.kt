package com.example.demo2

interface OnMainCallBack {
    fun callBack(key:String,data:Any?) {}       //để dấu {}. PT là PT default chỉ ghi đè khi cần
    fun showFragment(tag:String,data: Any?,isBacked:Boolean)
    fun closeApp() {}
    fun showFragment2(tag: String, data: Any?, isBacked: Boolean)
    fun showFragment3(tag: String, data: Any?, isBacked: Boolean)
}