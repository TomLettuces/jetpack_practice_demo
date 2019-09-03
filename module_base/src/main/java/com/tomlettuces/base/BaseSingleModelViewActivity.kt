package com.tomlettuces.base

import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
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
        bindViewModel()
        super.onCreate(savedInstanceState)
    }

    /**
     * viewModel与databinding绑定
     */
    abstract fun bindViewModel()


}
