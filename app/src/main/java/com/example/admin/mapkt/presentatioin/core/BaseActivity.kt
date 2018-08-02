package com.example.admin.mapkt.presentatioin.core

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    open fun inject() {

    }

    @LayoutRes
    abstract fun getLayoutId(): Int

}