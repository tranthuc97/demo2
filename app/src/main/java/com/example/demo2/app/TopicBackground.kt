package com.example.demo2.app

class TopicBackground (private var Topic:String, private var isSelected:Boolean) {
    val TOPIC:String
    get() = Topic

    var ISSELECTED:Boolean
        get() = isSelected
        set(value) {
            isSelected = value
        }
}