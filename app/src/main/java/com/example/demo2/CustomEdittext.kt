package com.example.demo2

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import com.example.demo2.databinding.ItemEditTextBinding

class CustomEdittext @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    var callback:CallBack? = null

    var binding:ItemEditTextBinding
    var text:MutableLiveData<String> = MutableLiveData("")

    init {
        binding = ItemEditTextBinding.inflate(LayoutInflater.from(context), this, true)
        initView()
    }

    private fun initView() {
        binding.edtInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun afterTextChanged(p0: Editable?) {
                callback?.callback(p0.toString())

            }
        })

        Log.i("TAG", "gettttt tren: ")
        binding.btButton.setOnClickListener {
            Toast.makeText(context, "${binding.edtInput.text}", Toast.LENGTH_SHORT).show()

        }
    }

    interface CallBack{
        fun callback(text:String)
    }


}