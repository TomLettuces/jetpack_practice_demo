package com.tomlettuces.base

import com.alibaba.android.arouter.launcher.ARouter
import com.tomlettuces.base.provider.IHomeProvider
import com.tomlettuces.base.provider.IUserProvider

/**
 * ARouter的provider管理类，用于返回不同模块的provider对象，以实现跨模块逻辑调用，即组件化。
 */
object ServiceManager {

    fun getHomeProvider(): IHomeProvider {
        return ARouter.getInstance().build(IHomeProvider.HOME_SERVICE).navigation() as IHomeProvider
    }

    fun getUserProvider(): IUserProvider {
        return ARouter.getInstance().build(IUserProvider.USER_SERVICE).navigation() as IUserProvider
    }

}