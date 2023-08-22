package com.example.demo2.app

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo2.App
import com.example.demo2.Icon
import com.example.demo2.R

class AdapterPhotoBackground(private var context: Context) : RecyclerView.Adapter<AdapterPhotoBackground.ClassHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPhotoBackground.ClassHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_photo2, parent,false)
        return ClassHolder(view)
    }

    override fun getItemCount(): Int {
        return App.INSTANCE.STORAGE.listIcon.size
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: AdapterPhotoBackground.ClassHolder, position: Int) {
        var data: Icon = App.INSTANCE.STORAGE.listIcon[position]       //thay Any bằng tên Model tương ứng
        holder.textView.text = data.TEXT
        holder.imgView.setImageDrawable(App.INSTANCE.resources.getDrawable(data.ICON))
    }

    inner class ClassHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView: ImageView =itemView.findViewById(R.id.imgView)
        var textView: TextView =itemView.findViewById(R.id.textView)
    }
}