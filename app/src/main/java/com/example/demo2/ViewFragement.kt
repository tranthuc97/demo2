package com.example.demo2

import com.example.demo2.databinding.FragmentHomeBinding

class ViewFragement : BaseFragment<FragmentHomeBinding>() {

    companion object {
        var TAG:String = ViewFragement::class.java.name
    }
    override fun initViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        var adapter = RecyclerViewAdapter(context1!!)
        binding!!.reView.adapter = adapter
    }
}