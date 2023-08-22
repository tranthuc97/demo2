package com.example.demo2.app

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.demo2.App
import com.example.demo2.Icon
import com.example.demo2.R
import com.example.demo2.RecyclerViewAdapter
import kotlin.math.log

class AdapterTopicBackground(private var context: Context, private var event:View.OnClickListener) : RecyclerView.Adapter<AdapterTopicBackground.ClassHolder>() {
    companion object{
        var TAG = AdapterTopicBackground::class.java.name
    }
    var listTopic:ArrayList<TopicBackground> = ArrayList()
    var topic:MutableLiveData<TopicBackground> = MutableLiveData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTopicBackground.ClassHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_topic, parent,false)
        return ClassHolder(view)
    }

    override fun getItemCount(): Int {
        if(listTopic.size == 0){
            listTopic.add(TopicBackground("Tourism",false))
            listTopic.add(TopicBackground("My Album",false))
            listTopic.add(TopicBackground("Nature",false))
            listTopic.add(TopicBackground("Structure",false))
            listTopic.add(TopicBackground("Sample",false))
        }
        return listTopic.size
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: AdapterTopicBackground.ClassHolder, position: Int) {
        var data: TopicBackground = listTopic[position]       //thay Any bằng tên Model tương ứng
        holder.textView.text = data.TOPIC
        holder.textView.tag = data
        if(data.ISSELECTED==true) holder.textView.setTextColor(Color.WHITE) else holder.textView.setTextColor(Color.GRAY)
    }

    inner class ClassHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView =itemView.findViewById(R.id.tvTopic)
        init {
            itemView.setOnClickListener{
                event.onClick(it)
                (textView.tag as TopicBackground).ISSELECTED = true
                if(topic.value !=null){
                    topic.value!!.ISSELECTED = false
                    Log.i(TAG,"isSelected old = ${topic.value!!.ISSELECTED}")
                }
                topic.postValue(textView.tag as TopicBackground)
                Log.i(TAG,"isSelected = ${(textView.tag as TopicBackground).ISSELECTED}")
                notifyItemRangeChanged(0,listTopic.size)
            }
        }
    }
}