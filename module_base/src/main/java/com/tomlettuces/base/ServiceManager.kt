package com.tomlettuces.base

import com.alibaba.android.arouter.launcher.ARouter
import com.tomlettuces.base.provider.IHomeProvider
import com.tomlettuces.base.provider.IUserProvider

object ServiceManager {

    fun getHomeProvider(): IHomeProvider {
        return ARouter.getInstance().build(IHomeProvider.HOME_SERVICE).navigation() as IHomeProvider
    }

    fun getUserProvider(): IUserProvider {
        return ARouter.getInstance().build(IUserProvider.USER_SERVICE).navigation() as IUserProvider
    }

}