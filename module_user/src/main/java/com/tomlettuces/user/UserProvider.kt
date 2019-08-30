package com.tomlettuces.user

import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.tomlettuces.base.provider.IUserProvider

@Route(path = IUserProvider.USER_SERVICE)
class UserProvider : IUserProvider {

    private var mContext: Context? = null

    override fun init(context: Context?) {
        mContext = context
    }

    override fun login() {
        Toast.makeText(mContext, "启动登录逻辑", Toast.LENGTH_SHORT).show()
    }


}