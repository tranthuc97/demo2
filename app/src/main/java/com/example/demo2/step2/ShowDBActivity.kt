package com.example.demo2.step2

import android.content.Intent
import com.example.demo2.BaseAct
import com.example.demo2.databinding.ActivityInputBinding

class ShowDBActivity:BaseAct<ActivityInputBinding>() {
    override fun initViewBinding(): ActivityInputBinding {
        return ActivityInputBinding.inflate(layoutInflater)
    }

    override fun initViews() {

    }
}