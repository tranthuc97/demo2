package com.example.demo2

import android.util.Log
import android.view.ViewGroup
import android.widget.NumberPicker
import com.example.demo2.databinding.ActivityMainBinding
import com.example.demo2.dialog.BaseBottomSheet
import com.example.demo2.dialog.DialogTest
import me.angrybyte.numberpicker.listener.OnValueChangeListener
import me.angrybyte.numberpicker.view.ActualNumberPicker


class MainActivity : BaseAct<ActivityMainBinding>(), BaseBottomSheet.CallBack{
    companion object {
        var TAG = MainActivity::class.java.name
    }

    var mPicker:ActualNumberPicker? = null


    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding!!.ivClickBS.setOnClickListener{
            showDialog()

        }
    }

    override fun showDialog() {
        var dialog = DialogTest(this)

        dialog!!.callBack = this      //ghi đè PT showDialog() chính là cái PT đang diễn ra này
        dialog!!.show()
    }


}