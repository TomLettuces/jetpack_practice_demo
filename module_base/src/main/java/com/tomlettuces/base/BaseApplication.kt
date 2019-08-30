package com.tomlettuces.base

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.squareup.leakcanary.LeakCanary

class BaseApplication : Application() {

    companion object {
        val MODULESLIST = arrayOf("com.tomlettuces.home.HomeApplication", "com.tomlettuces.user.UserApplication")

        var mApplicationContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        mApplicationContext = this.applicationContext
        commonApplicationInit()
        modulesApplicationInit()
    }

    /**
     * 处理公共库的初始化
     */
    private fun commonApplicationInit() {
        initRouter(this)
        initLeakCanary(this)

    }

    /**
     * 处理各自module的初始化
     */
    private fun modulesApplicationInit() {
        for (moduleImpl in MODULESLIST) {
            val clazz: Class<*> = Class.forName(moduleImpl)
            val obj: Any = clazz.newInstance()
            if (obj is IComponentApplication) {
                obj.init(this)
            }

        }
    }

    private fun initRouter(myApplication: Application) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()  // 打印日志
            ARouter.openDebug()// 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(myApplication)
    }

    private fun initLeakCanary(myApplication: Application) {
        // 检查当前进程是否为HeapAnalyzerService所属进程
        if (LeakCanary.isInAnalyzerProcess(myApplication)) {
            return
        }
        LeakCanary.install(myApplication)
    }


}