package com.example.demo2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(private var context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ClassHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val view:View =LayoutInflater.from(context).inflate(R.layout.itemview, parent,false)
        return ClassHolder(view)
    }

    override fun getItemCount(): Int {
        return App.INSTANCE.storage.listIcon.size
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        var data: Icon = App.INSTANCE.storage.listIcon[position]       //thay Any bằng tên Model tương ứng
        holder.textView.text = data.TEXT
        holder.imgView.setImageDrawable(App.INSTANCE.resources.getDrawable(data.ICON))
    }

    inner class ClassHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView:ImageView =itemView.findViewById(R.id.imgView)
        var textView:TextView =itemView.findViewById(R.id.textView)
    }

}