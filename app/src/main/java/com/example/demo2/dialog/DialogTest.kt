package com.example.demo2.dialog

import android.content.Context
import android.content.DialogInterface
import com.example.demo2.databinding.BottomSheetBinding

class DialogTest(context:Context):BaseBottomSheet<BottomSheetBinding>(context) {
    override fun initViewBinding(): BottomSheetBinding? {
        return BottomSheetBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        //do nothing
    }


}