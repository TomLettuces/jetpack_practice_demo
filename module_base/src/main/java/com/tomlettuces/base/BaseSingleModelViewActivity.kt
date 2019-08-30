package com.tomlettuces.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.ViewDataBinding
import android.os.Bundle
import java.lang.reflect.ParameterizedType

abstract class BaseSingleModelViewActivity<VM : ViewModel, DB : ViewDataBinding> : BaseActivity<DB>() {

    protected val mViewModel: VM by lazy {
        ViewModelProviders.of(this).get(getTClass())
    }

    @Suppress("UNCHECKED_CAST")
    private fun getTClass(): Class<VM> {
        return (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    abstract fun bindViewModel()


}
