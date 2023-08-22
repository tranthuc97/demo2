package com.example.demo2

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.R
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewbinding.ViewBinding
import java.lang.reflect.Constructor

abstract class BaseAct<V : ViewBinding> : AppCompatActivity(), OnClickListener,
    OnMainCallBack {
    protected var binding: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initViewBinding()
        setContentView(binding!!.root)

        initViews()
    }


    abstract fun initViewBinding(): V

    abstract fun initViews()

    final override fun onClick(v: View?) {
        v!!.startAnimation(AnimationUtils.loadAnimation(this, R.anim.abc_fade_in))
        clickView(v)
    }

    protected fun clickView(v: View) {
        //do sothing
    }

    protected fun showNotify(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun showNotify(msg: Int) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showFragment(tag: String, data: Any?, isBacked: Boolean) {
        try {
            var clazz: Class<*> = Class.forName(tag)        //trỏ vào một fragment class thông qua tag truyền vào
            var constructor: Constructor<*> = clazz.getConstructor()        //tạo Constructor
            var baseFragment: BaseFragment<*> = constructor.newInstance() as BaseFragment<*>        //Tạo 1 thực thể từ lớp Fragment

            baseFragment.CALLBACK = this
            if(data!=null){
                baseFragment.DATA = data
            }

            var trans: FragmentTransaction = supportFragmentManager.beginTransaction()
                .replace(com.example.demo2.R.id.ln_mainAct, baseFragment, tag)

            if (isBacked) {
                trans.addToBackStack(null)      //trở về màn hình trước đó, true thì có cho phép back
            }
            trans.setCustomAnimations(R.anim.abc_fade_in,R.anim.abc_fade_out)       //custom hiệu ứng khi chuyển tiếp các fragment
            trans.commit()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun showFragment2(tag: String, data: Any?, isBacked: Boolean) {
        try {
            var clazz: Class<*> = Class.forName(tag)        //trỏ vào một fragment class thông qua tag truyền vào
            var constructor: Constructor<*> = clazz.getConstructor()        //tạo Constructor
            var baseFragment: BaseFragment<*> = constructor.newInstance() as BaseFragment<*>        //Tạo 1 thực thể từ lớp Fragment

            baseFragment.CALLBACK = this
            if(data!=null){
                baseFragment.DATA = data
            }

            var trans: FragmentTransaction = supportFragmentManager.beginTransaction()
                .replace(com.example.demo2.R.id.lnActBackground, baseFragment, tag)

            if (isBacked) {
                trans.addToBackStack(null)      //trở về màn hình trước đó, true thì có cho phép back
            }
            trans.setCustomAnimations(R.anim.abc_fade_in,R.anim.abc_fade_out)       //custom hiệu ứng khi chuyển tiếp các fragment
            trans.commit()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun showFragment3(tag: String, data: Any?, isBacked: Boolean) {
        try {
            var clazz: Class<*> = Class.forName(tag)        //trỏ vào một fragment class thông qua tag truyền vào
            var constructor: Constructor<*> = clazz.getConstructor()        //tạo Constructor
            var baseFragment: BaseFragment<*> = constructor.newInstance() as BaseFragment<*>        //Tạo 1 thực thể từ lớp Fragment

            baseFragment.CALLBACK = this
            if(data!=null){
                baseFragment.DATA = data
            }

            var trans: FragmentTransaction = supportFragmentManager.beginTransaction()
                .replace(com.example.demo2.R.id.frFragment, baseFragment, tag)

            if (isBacked) {
                trans.addToBackStack(null)      //trở về màn hình trước đó, true thì có cho phép back
            }
            trans.setCustomAnimations(R.anim.abc_fade_in,R.anim.abc_fade_out)       //custom hiệu ứng khi chuyển tiếp các fragment
            trans.commit()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}