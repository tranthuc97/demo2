package com.example.demo2.step2

import android.util.Log
import com.example.demo2.BaseAct
import com.example.demo2.databinding.ActivityBmiBinding

class BMIActivity:BaseAct<ActivityBmiBinding>() {
    override fun initViewBinding(): ActivityBmiBinding {
        return ActivityBmiBinding.inflate(layoutInflater)
    }

    override fun initViews() {


        binding!!.edtBMI.setOnClickListener{
            Log.i(StepActivity.TAG, "chỉ số: ${binding!!.edtWeight.text.toString()}, ${binding!!.edtHeight.text.toString()}")
            binding!!.tvBMI.text = ((binding!!.edtWeight.text.toString().toFloat() * 10000F)/(binding!!.edtHeight.text.toString().toFloat() * binding!!.edtHeight.text.toString().toFloat())).toString()
        }
    }
}