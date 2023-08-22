package com.example.demo2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log


class RecyclerViewAdapter2(private var context: Context, private var list:MutableList<Photo>, private var event:View.OnClickListener) : RecyclerView.Adapter<RecyclerViewAdapter2.ClassHolder>() {
    companion object {
        var TAG:String = RecyclerViewAdapter2::class.java.name
    }

    private var key:MutableLiveData<String> = MutableLiveData("")
    val KEY:MutableLiveData<String>
        get() = key

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val view:View =LayoutInflater.from(context).inflate(R.layout.itemimageview, parent,false)
        return ClassHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        var data: Photo = list[position]       //thay Any bằng tên Model tương ứng
        holder.imgView.setImageDrawable(App.INSTANCE.resources.getDrawable(data.PHOTO))
        holder.imgView.tag = data.NAMEPHOTO
    }

    inner class ClassHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView:ImageView =itemView.findViewById(R.id.iv)

        init {
            itemView.setOnClickListener{
                it.startAnimation(AnimationUtils.loadAnimation(context,
                    androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom))
                event.onClick(it)
                key.value = imgView.tag as String
                Log.i(TAG,"key = ${key.value}")
            }
        }
    }

}