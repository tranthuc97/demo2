package com.example.demo2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(private val items: List<String>) : BaseAdapter() {
    override fun getCount(): Int = items.size
    override fun getItem(position: Int): Any = items[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_adapter_noti, parent, false)
        view.findViewById<TextView>(R.id.textView).text = items[position]
        return view
    }
}