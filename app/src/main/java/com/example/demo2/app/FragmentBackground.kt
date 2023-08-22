package com.example.demo2.app

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.demo2.BaseFragment
import com.example.demo2.R
import com.example.demo2.databinding.FragmentBackgroundBinding

class FragmentBackground : BaseFragment<FragmentBackgroundBinding>() {
    companion object{
        var TAG = FragmentBackground::class.java.name
    }
    private var adapterTopic:AdapterTopicBackground? = null

    override fun initViewBinding(): FragmentBackgroundBinding {
        return FragmentBackgroundBinding.inflate(layoutInflater)
    }

    @SuppressLint("ResourceAsColor")
    override fun initViews() {
        adapterTopic = AdapterTopicBackground(context1!!){
            //do something
        }
        binding!!.reTopic.adapter = adapterTopic
    }
}