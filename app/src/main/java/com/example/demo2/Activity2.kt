package com.example.demo2

import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.example.demo2.databinding.Activity2Binding

@Suppress("UNREACHABLE_CODE")
class Activity2 : BaseAct<Activity2Binding>() {
    var adapter:RecyclerViewAdapter2? = null
    companion object {
        var TAB1:String = "tab1"
        var TAB2:String = "tab2"
        var TAB3:String = "tab3"
        var TAB4:String = "tab4"
        var TAB5:String = "tab5"
        var TAB6:String = "tab6"
        var TAB7:String = "tab7"
        var TAB8:String = "tab8"
        var TAB9:String = "tab9"
        var TAB10:String = "tab10"
    }
    override fun initViewBinding(): Activity2Binding {
        return Activity2Binding.inflate(layoutInflater)

    }

    override fun initViews() {
        if(App.INSTANCE.STORAGE.listPhoto1.isEmpty()){
            addPhoto1()
            //addPhoto2()
            //addPhoto3()
            //addPhoto4()
            //addPhoto5()
            //addPhoto6()
            //addPhoto7()
        }

        binding!!.tv1.setOnClickListener{

            binding!!.tv1.startAnimation(AnimationUtils.loadAnimation(this,
                androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom))
            adapter = RecyclerViewAdapter2(this,App.INSTANCE.STORAGE.listPhoto1){
                adapter!!.KEY.observe(this){
                    changeColorBackground(it)
                }
            }
            binding!!.recyclerView.adapter = adapter
        }

        binding!!.yourFragment.setBackgroundColor(4293511982.toInt())

        /*
        binding!!.tv2.setOnClickListener{
            binding!!.tv2.startAnimation(AnimationUtils.loadAnimation(this,
                androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom))
            var adapter = RecyclerViewAdapter2(this,App.INSTANCE.STORAGE.listPhoto2)
            binding!!.recyclerView.adapter = adapter
        }

        binding!!.tv3.setOnClickListener{
            binding!!.tv3.startAnimation(AnimationUtils.loadAnimation(this,
                androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom))
            var adapter = RecyclerViewAdapter2(this,App.INSTANCE.STORAGE.listPhoto3)
            binding!!.recyclerView.adapter = adapter
        }

        binding!!.tv4.setOnClickListener{
            binding!!.tv4.startAnimation(AnimationUtils.loadAnimation(this,
                androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom))
            var adapter = RecyclerViewAdapter2(this,App.INSTANCE.STORAGE.listPhoto4)
            binding!!.recyclerView.adapter = adapter
        }

        binding!!.tv5.setOnClickListener{
            binding!!.tv5.startAnimation(AnimationUtils.loadAnimation(this,
                androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom))
            var adapter = RecyclerViewAdapter2(this,App.INSTANCE.STORAGE.listPhoto5)
            binding!!.recyclerView.adapter = adapter
        }

        binding!!.tv6.setOnClickListener{
            binding!!.tv6.startAnimation(AnimationUtils.loadAnimation(this,
                androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom))
            var adapter = RecyclerViewAdapter2(this,App.INSTANCE.STORAGE.listPhoto6)
            binding!!.recyclerView.adapter = adapter
        }

        binding!!.tv7.setOnClickListener{
            binding!!.tv7.startAnimation(AnimationUtils.loadAnimation(this,
                androidx.appcompat.R.anim.abc_grow_fade_in_from_bottom))
            var adapter = RecyclerViewAdapter2(this,App.INSTANCE.STORAGE.listPhoto7)
            binding!!.recyclerView.adapter = adapter
        }
         */
    }

    private fun changeColorBackground(key: String?) {
        if(key == TAB1){
            binding!!.lnAct2.setBackgroundResource(R.color.colorGrey)
        } else if(key == TAB2){
            binding!!.lnAct2.setBackgroundResource(R.color.purple_200)
        }else if(key == TAB3){
            binding!!.lnAct2.setBackgroundResource(R.color.purple_500)
        }else if(key == TAB4){
            binding!!.lnAct2.setBackgroundResource(R.color.purple_700)
        }else if(key == TAB5){
            binding!!.lnAct2.setBackgroundResource(R.color.teal_200)
        }else if(key == TAB6){
            binding!!.lnAct2.setBackgroundResource(R.color.teal_700)
        }else if(key == TAB7){
            binding!!.lnAct2.setBackgroundResource(R.color.colorGrey)
        }else if(key == TAB8){
            binding!!.lnAct2.setBackgroundResource(R.color.purple_200)
        }else if(key == TAB9){
            binding!!.lnAct2.setBackgroundResource(R.color.purple_500)
        }else if(key == TAB10){
            binding!!.lnAct2.setBackgroundResource(R.color.purple_700)
        }
    }

    private fun addPhoto1() {
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view1, TAB1))
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view2, TAB2))
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view3, TAB3))
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view4, TAB4))
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view5, TAB5))
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view6, TAB6))
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view7, TAB7))
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view8, TAB8))
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view9, TAB9))
        App.INSTANCE.STORAGE.listPhoto1.add(Photo(R.drawable.ic_view10, TAB10))
    }
    /*
    private fun addPhoto2() {
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view10))
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view9))
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view8))
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view7))
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view6))
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view5))
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view4))
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view8))
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view9))
        App.INSTANCE.STORAGE.listPhoto2.add(Photo(R.drawable.ic_view10))
    }
    private fun addPhoto3() {
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view5))
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view6))
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view2))
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view4))
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view5))
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view7))
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view7))
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view8))
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view9))
        App.INSTANCE.STORAGE.listPhoto3.add(Photo(R.drawable.ic_view1))
    }
    private fun addPhoto4() {
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view9))
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view5))
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view7))
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view2))
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view7))
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view10))
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view7))
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view8))
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view1))
        App.INSTANCE.STORAGE.listPhoto4.add(Photo(R.drawable.ic_view10))
    }
    private fun addPhoto5() {
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view2))
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view6))
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view9))
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view10))
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view1))
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view2))
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view9))
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view8))
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view9))
        App.INSTANCE.STORAGE.listPhoto5.add(Photo(R.drawable.ic_view2))
    }
    private fun addPhoto6() {
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view2))
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view5))
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view1))
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view6))
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view2))
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view3))
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view10))
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view8))
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view9))
        App.INSTANCE.STORAGE.listPhoto6.add(Photo(R.drawable.ic_view4))
    }
    private fun addPhoto7() {
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view6))
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view7))
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view10))
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view9))
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view2))
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view6))
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view7))
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view5))
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view7))
        App.INSTANCE.STORAGE.listPhoto7.add(Photo(R.drawable.ic_view8))
    }
     */

}