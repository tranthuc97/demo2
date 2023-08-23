package com.example.demo2.step2

import android.content.Intent
import com.example.demo2.BaseAct
import com.example.demo2.databinding.ActivityInput2Binding
import com.example.demo2.databinding.ActivityInputBinding

class Input2Activity:BaseAct<ActivityInput2Binding>() {
    override fun initViewBinding(): ActivityInput2Binding {
        return ActivityInput2Binding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding!!.btNext.setOnClickListener{
            if(binding!!.edtHeight.text.toString().isEmpty() || binding!!.edtWeight.text.toString().isEmpty() || binding!!.edtTarget.text.toString().isEmpty()){
                showNotify("input information")
            }else{
                CommonUtils.INSTANCE.savePrefs(Constant.HEIGHT,binding!!.edtHeight.text.toString())
                CommonUtils.INSTANCE.savePrefs(Constant.WEIGHT,binding!!.edtWeight.text.toString())
                CommonUtils.INSTANCE.savePrefs(Constant.TARGETWEIGHT,binding!!.edtTarget.text.toString())
                CommonUtils.INSTANCE.savePrefs(Constant.BMI,((binding!!.edtWeight.text.toString().toFloat() * 10000F)/(binding!!.edtHeight.text.toString().toFloat() * binding!!.edtHeight.text.toString().toFloat())).toString())

                startActivity(Intent(this, StepActivity()::class.java))
            }
        }
    }
}