package com.example.demo2.app

class PhotoBackground (private var photo:Int, private var isSelected:Boolean) {
    val PHOTO:Int
        get() = photo

    var ISSELECTED:Boolean
        get() = isSelected
        set(value) {
            isSelected = value
        }
}