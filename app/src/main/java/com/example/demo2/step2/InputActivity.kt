package com.example.demo2.step2

import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.demo2.BaseAct
import com.example.demo2.databinding.ActivityInputBinding
import com.example.demo2.step2.db.Info

class InputActivity:BaseAct<ActivityInputBinding>() {
    override fun initViewBinding(): ActivityInputBinding {
        return ActivityInputBinding.inflate(layoutInflater)
    }

    override fun initViews() {

        binding!!.btNext.visibility = ViewGroup.INVISIBLE
        binding!!.tvMale.setOnClickListener(this)
        binding!!.tvFemale.setOnClickListener(this)


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

    override fun clickView(v: View) {
        if(v == binding!!.tvMale){
            binding!!.btNext.visibility = ViewGroup.VISIBLE
            CommonUtils.INSTANCE.savePrefs(Constant.SEX, binding!!.tvMale.tag.toString())
            binding!!.tvMale.isEnabled
            binding!!.tvFemale.isEnabled
        }else if(v == binding!!.tvFemale){
            binding!!.btNext.visibility = ViewGroup.VISIBLE
            CommonUtils.INSTANCE.savePrefs(Constant.SEX, binding!!.tvFemale.tag.toString())
            binding!!.tvMale.isEnabled
            binding!!.tvFemale.isEnabled
        }
    }
}