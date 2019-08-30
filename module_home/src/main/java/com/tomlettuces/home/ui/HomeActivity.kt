package com.tomlettuces.home.ui

import android.util.Log
import androidx.fragment.app.FragmentManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.tomlettuces.base.BaseSingleModelViewActivity
import com.tomlettuces.base.RouterPath
import com.tomlettuces.base.ServiceManager
import com.tomlettuces.base.provider.IHomeProvider
import com.tomlettuces.home.R
import com.tomlettuces.home.databinding.ActivityHomeBinding
import com.tomlettuces.home.viewmodel.HomeViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*

@Route(path = IHomeProvider.HOME)
class HomeActivity : BaseSingleModelViewActivity<HomeViewModel, ActivityHomeBinding>() {

    override fun bindViewModel() {
        mBinding.viewModel = mViewModel
    }

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initView() {
        mViewModel.changeData()
        btn_access_login.setOnClickListener {
            ARouter.getInstance().build(RouterPath.LOGIN).withString("name", "Andy").navigation()
        }
        btn_test_login.setOnClickListener {
            ServiceManager.getUserProvider().login()
        }

//        btn_access_login.text = "睡觉啊好短发十分艰难".lastChar().toString()

        val fragment1 = HomeFragment1()
        Log.i("Fragment_Lifecycle", "after new fragment1")
        val fragment2 = HomeFragment2()
        Log.i("Fragment_Lifecycle", "after new fragment2")
        val fragmentManager: FragmentManager = supportFragmentManager
        Log.i("Fragment_Lifecycle", "after supportFragmentManager")
        val fragmentTransaction = fragmentManager.beginTransaction()
        Log.i("Fragment_Lifecycle", "after fragmentManager.beginTransaction")
        fragmentTransaction.add(R.id.fragment_container1, fragment1)
        Log.i("Fragment_Lifecycle", "after fragmentTransaction add fragment1")
        fragmentTransaction.add(R.id.fragment_container2, fragment2)
        Log.i("Fragment_Lifecycle", "after fragmentTransaction add fragment2")
        fragmentTransaction.show(fragment1)
        Log.i("Fragment_Lifecycle", "after fragmentTransaction show fragment1")
//        fragmentTransaction.show(fragment2)
        fragmentTransaction.hide(fragment2)
//        Log.i("Fragment_Lifecycle", "after fragmentTransaction hide fragment2")
        fragmentTransaction.commit()
        Log.i("Fragment_Lifecycle", "after fragmentTransaction commit")


        testRxJavaScheduler()
    }

    override fun loadData() {

    }

    fun testRxJavaScheduler() {

        Observable.just("Hello World")
//            .observeOn(Schedulers.computation())
            .map {
                val result = it.toLowerCase()
                Log.i("Scheduler", "CurrentThread=${Thread.currentThread()};result=$result")
                result
            }
//            .observeOn(Schedulers.io())
            .map {
                val result = it + " Now"
                Log.i("Scheduler", "CurrentThread=${Thread.currentThread()};result=$it")
                result
            }
            .observeOn(Schedulers.single())
//            .subscribeOn(Schedulers.single())
            .map {
                val result = it.removeRange(0, 4)
                Log.i("Scheduler", "CurrentThread=${Thread.currentThread()};result=$it")
                result
            }
//            .subscribeOn(Schedulers.io())
            .subscribe {
                Log.i("Scheduler", "CurrentThread=${Thread.currentThread()};result=$it")
            }

    }
}