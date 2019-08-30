package com.tomlettuces.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var mContext: Context

    protected val mBinding: DB by lazy {
        DataBindingUtil.setContentView<DB>(this, getLayoutId())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        mBinding.executePendingBindings()
//        mBinding.lifecycleOwner = this

        initView()
        loadData()

        ARouter.getInstance().inject(this)
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun loadData()
}
