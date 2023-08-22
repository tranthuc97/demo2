package com.example.demo2.app

import com.example.demo2.BaseAct
import com.example.demo2.databinding.ActivityBackgorundBinding

class ActivityBackground : BaseAct<ActivityBackgorundBinding>() {
    override fun initViewBinding(): ActivityBackgorundBinding {
        return ActivityBackgorundBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        showFragment2(FragmentBackground.TAG,null,false)
    }
}