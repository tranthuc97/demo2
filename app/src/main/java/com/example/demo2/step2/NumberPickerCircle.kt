package com.example.demo2.step2

import android.widget.NumberPicker
import com.example.demo2.BaseAct
import com.example.demo2.R
import com.example.demo2.databinding.ActivityNumberPickerCircleBinding

class NumberPickerCircle : BaseAct<ActivityNumberPickerCircleBinding>() {
    override fun initViewBinding(): ActivityNumberPickerCircleBinding {
        return ActivityNumberPickerCircleBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        // Get the number picker view.
        val numberPicker = findViewById<NumberPicker>(R.id.npNumberPicker)

        // Set the properties of the number picker.



        // Set the listener for the number picker.
        numberPicker.setOnValueChangedListener { _, oldVal, newVal ->
            // Do something when the value of the number picker changes.
        }
    }
}