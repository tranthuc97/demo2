package com.example.demo2

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView


class RatioView2(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    RecyclerView(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context) : this(context, null, 0)

    private var scrollable = true

    fun setScrollingEnabled(scrollable: Boolean) {
        this.scrollable = scrollable
    }

    fun isScrollable(): Boolean {
        return scrollable
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                // if we can scroll pass the event to the superclass
                if (scrollable) super.onTouchEvent(ev) else scrollable
                // only continue to handle the touch event if scrolling enabled
                // scrollable is always false at this point
            }

            else -> super.onTouchEvent(ev)
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        // Don't do anything with intercepted touch events if
        // we are not scrollable
        return if (!scrollable) false else super.onInterceptTouchEvent(ev)
    }


}