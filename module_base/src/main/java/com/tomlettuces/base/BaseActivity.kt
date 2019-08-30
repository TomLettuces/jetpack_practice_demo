package com.tomlettuces.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.alibaba.android.arouter.launcher.ARouter

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var mContext: Context

    protected val mBinding: DB by lazy {
        DataBindingUtil.setContentView<DB>(this, getLayoutId())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        if (mBinding != null) {
            mBinding.executePendingBindings()
            mBinding.lifecycleOwner = this
        }

        initView()
        loadData()

        ARouter.getInstance().inject(this)
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun loadData()
}
