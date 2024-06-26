package com.example.demo2

import com.example.demo2.databinding.ActivityTestAdapterBinding
import android.graphics.Canvas
import androidx.recyclerview.widget.RecyclerView

class TestAdapterActivity : BaseAct<ActivityTestAdapterBinding>() {

    override fun initViewBinding(): ActivityTestAdapterBinding {
        return ActivityTestAdapterBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        var items = listOf("item1", "item 2", "item 3", "item 4", "item 5", "item 6", "item 7", "item 8", "item 9", "item 10")
        var adapter = MyAdapter(items)
        binding?.stackView?.adapter = adapter
//        binding?.reListNoti?.adapter = adapter
    }
}



class CustomItemDecoration : RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val childCount = parent.childCount
        val adapter = parent.adapter

        if (adapter != null) {
            for (i in 0 until childCount) {
                val view = parent.getChildAt(i)
                val position = parent.getChildAdapterPosition(view)

                if (position > 2) {
                    view.alpha = 0.5f
                    view.scaleX = 0.9f
                    view.scaleY = 0.9f
                } else if (position > 1) {
                    view.alpha = 0.7f
                    view.scaleX = 0.95f
                    view.scaleY = 0.95f
                }
            }
        }
    }
}