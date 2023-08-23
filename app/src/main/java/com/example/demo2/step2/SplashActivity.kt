package com.example.demo2.step2

import android.content.Intent
import com.example.demo2.BaseAct
import com.example.demo2.databinding.ActivitySplashBinding

class SplashActivity : BaseAct<ActivitySplashBinding>() {
    override fun initViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun initViews() {

        binding!!.btLetsGo.setOnClickListener{
            if(CommonUtils.INSTANCE.getPrefs(Constant.NAME) == null){
                startActivity(Intent(this, InputActivity()::class.java))
            }else {
                startActivity(Intent(this, Input2Activity()::class.java))
            }
        }
    }
}