package com.tomlettuces.home

import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.tomlettuces.base.provider.IHomeProvider

@Route(path = IHomeProvider.HOME_SERVICE)
class HomeProvider : IHomeProvider {

    private var mContext: Context? = null


    override fun init(context: Context?) {
        mContext = context
    }

    override fun toast(msg: String) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
    }
}