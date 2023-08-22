package com.example.demo2.step2

import android.os.Handler
import android.util.Log
import com.example.demo2.BaseFragment
import com.example.demo2.databinding.FragmentTimeBinding

class TimeFragment : BaseFragment<FragmentTimeBinding>() {
    override fun initViewBinding(): FragmentTimeBinding {
        return FragmentTimeBinding.inflate(layoutInflater)
    }

    companion object {
        var TAG = TimeFragment::class.java.name
    }
     var actStep = StepActivity()

    var count = 0

    override fun initViews() {
        Handler().postDelayed({
            actStep.countStep.observe(this){
                if(count != it){
                    count = it
                    Log.i(TAG, "time1 run")
                }else{
                    Log.i(TAG, "time1 stop")
                }
            }
        }, 2000)
    }
}