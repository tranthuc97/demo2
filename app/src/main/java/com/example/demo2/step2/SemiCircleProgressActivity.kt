package com.example.demo2.step2

import android.widget.Button
import android.widget.TextView
import com.example.demo2.BaseAct
import com.example.demo2.R
import com.example.demo2.databinding.ActivitySemicircleProgressBinding
import java.util.Random

class SemiCircleProgressActivity : BaseAct<ActivitySemicircleProgressBinding>() {
    override fun initViewBinding(): ActivitySemicircleProgressBinding {
        return ActivitySemicircleProgressBinding.inflate(layoutInflater)
    }


    override fun initViews() {
        val circleView: SemiCircleProgress = findViewById(R.id.prProgress)
        val progressTv:TextView = findViewById(R.id.tvProgress)
        val changeProgressButton:Button = findViewById(R.id.btTap)

        circleView.setupUI(R.color.yellow)
        changeProgressButton.setOnClickListener {
            val progress = Random().nextInt(100)
            progressTv.text = "$progress %"
            circleView.setProgress(progress/100f)
        }
    }
}