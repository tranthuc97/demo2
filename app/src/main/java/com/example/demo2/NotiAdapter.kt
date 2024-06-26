package com.example.demo2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotiAdapter(private var context: Context, private val items: List<String>) : RecyclerView.Adapter<NotiAdapter.ClassHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_adapter_noti, parent,false)
        return ClassHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ClassHolder, position: Int) {
        holder.textView.text = items[position]
    }

    inner class ClassHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView =itemView.findViewById(R.id.tvTitle)
    }

}