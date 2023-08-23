package com.example.demo2.step2

import android.content.Intent
import android.util.Log
import com.example.demo2.BaseAct
import com.example.demo2.databinding.ActivityInputBinding

class InputActivity:BaseAct<ActivityInputBinding>() {
    override fun initViewBinding(): ActivityInputBinding {
        return ActivityInputBinding.inflate(layoutInflater)
    }

    override fun initViews() {


        binding!!.btNext.setOnClickListener{
            if(binding!!.edtName.text.toString().isEmpty() || binding!!.edtAge.text.toString().isEmpty()){
                showNotify("input information")
            }else{
                CommonUtils.INSTANCE.savePrefs(Constant.NAME,binding!!.edtName.text.toString())
                Log.i("TAG", "initViews: check null ${binding!!.edtAge.text.toString()}")
                CommonUtils.INSTANCE.savePrefs(Constant.AGE,binding!!.edtAge.text.toString())
                startActivity(Intent(this, Input2Activity()::class.java))
            }
        }

    }
}