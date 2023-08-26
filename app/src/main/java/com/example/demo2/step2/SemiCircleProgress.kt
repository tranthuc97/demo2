package com.example.demo2.step2

import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import com.example.demo2.R

class SemiCircleProgress constructor(
    context: Context, attrs: AttributeSet
) : View(context, attrs) {
    private var backgroundPaint: Paint = Paint()
    private var mainPaint: Paint = Paint()
    private var progress: Float = 0f
    private var margin: Float = resources.getDimension(R.dimen.d_20dp) // Lề cho progress, 6dp

    fun setupUI(colorRes: Int) {
        setupPaint(backgroundPaint, R.color.colorGrey)
        setupPaint(mainPaint, colorRes)
        invalidate()
    }
    private fun setupPaint(paint: Paint, colorRes: Int) {
        paint.isAntiAlias = true // Giúp các viền của view mịn màng hơn
        paint.color = ContextCompat.getColor(context, colorRes) // Màu của đường tròn
        paint.style = Paint.Style.STROKE // Chọn dạng stroke
        paint.strokeCap = Paint.Cap.ROUND // Hình dạng 2 đầu paint (ROUND là bo tròn)
        paint.strokeWidth =
            resources.getDimension(R.dimen.d_20dp) // 12dp, Độ rộng của đường tròn
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //set khung
        val frame = RectF(margin, margin,
            width.toFloat() - margin,
            height.toFloat() - margin) // Set khoảng cách viền margin cho đường tròn không bị tràn lề

        //vẽ proogress
        canvas?.drawArc(
            frame, // Khung bao quanh đường tròn
            170f, // Góc bắt đầu vẽ, tính theo độ, full là 360
            200f, // Độ dài cung vẽ
            false, // Có sử dụng tâm để vẽ không
            backgroundPaint
        ) // Chọn paint vẽ

        canvas?.drawArc(frame, 170f, progress * 200f, false, mainPaint) // Vẽ progress
    }

    fun setProgress(v: Float) {
        val currentProgress = this.progress
        val animator = ValueAnimator().apply { // Thực hiện hiệu ứng chuyển động khi thay đổi progress
            setValues(
                PropertyValuesHolder.ofFloat(
                "percent",
                currentProgress,v
            ))
            duration = 300
            interpolator = AccelerateDecelerateInterpolator()

            addUpdateListener {
                val newValue = it.getAnimatedValue("percent") as Float
                this@SemiCircleProgress.progress = newValue
                invalidate()
            }
        }
        animator.start()
    }

}