package com.example.demo2

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo2.databinding.ActivityHomeBinding

class HomeAct : BaseAct<ActivityHomeBinding>() {
    private var mRecyclerView:RecyclerView? = null
    private var adapter:RecyclerViewAdapter? = null
    private var mLayoutManager:RecyclerView.LayoutManager? = null   //set kiểu hển thị là kiểu layout của recyc

    override fun initViewBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        if (App.INSTANCE.STORAGE.listIcon.isEmpty()) {
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view1, "view1"))
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view2, "view2"))
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view3, "view3"))
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view4, "view4"))
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view5, "view5"))
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view6, "view6"))
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view7, "view7"))
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view8, "view8"))
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view9, "view9"))
            App.INSTANCE.STORAGE.listIcon.add(Icon(R.drawable.ic_view10, "view10"))
        }



        binding!!.iv3.setOnClickListener{
            binding!!.iv3.startAnimation(AnimationUtils.loadAnimation(this,androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom))
            mRecyclerView = binding!!.reView
            mRecyclerView!!.setHasFixedSize(true)   //cố định dữ liệu
            mLayoutManager = LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false)    //LinearLayoutManager set Recyc là cuộn ngang
            adapter = RecyclerViewAdapter(this)

            mRecyclerView!!.layoutManager = mLayoutManager      //set kiểu hiển thị layout
            mRecyclerView!!.adapter = adapter   //set adapter
        }
    }

}