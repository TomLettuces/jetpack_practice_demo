package com.tomlettuces.home.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.tomlettuces.base.provider.IHomeProvider
import com.tomlettuces.home.R

@Route(path = IHomeProvider.HOME)
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

//    override fun bindViewModel() {
//        mBinding.viewModel = mViewModel
//    }

//    override fun getLayoutId(): Int = R.layout.activity_home
//
//    override fun initView() {
////        mViewModel.changeData()
//        btn_access_login.setOnClickListener {
//            ARouter.getInstance().build(RouterPath.LOGIN).withString("name", "Andy").navigation()
//        }
//        btn_test_login.setOnClickListener {
//            ServiceManager.getUserProvider().login()
//        }
//
////        btn_access_login.text = "睡觉啊好短发十分艰难".lastChar().toString()
//
//        val fragment1 = HomeFragment1()
//        Log.i("Fragment_Lifecycle", "after new fragment1")
//        val fragment2 = HomeFragment2()
//        Log.i("Fragment_Lifecycle", "after new fragment2")
//        val fragmentManager: FragmentManager = supportFragmentManager
//        Log.i("Fragment_Lifecycle", "after supportFragmentManager")
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        Log.i("Fragment_Lifecycle", "after fragmentManager.beginTransaction")
//        fragmentTransaction.add(R.id.fragment_container1, fragment1)
//        Log.i("Fragment_Lifecycle", "after fragmentTransaction add fragment1")
//        fragmentTransaction.add(R.id.fragment_container2, fragment2)
//        Log.i("Fragment_Lifecycle", "after fragmentTransaction add fragment2")
//        fragmentTransaction.show(fragment1)
//        Log.i("Fragment_Lifecycle", "after fragmentTransaction show fragment1")
////        fragmentTransaction.show(fragment2)
//        fragmentTransaction.hide(fragment2)
////        Log.i("Fragment_Lifecycle", "after fragmentTransaction hide fragment2")
//        fragmentTransaction.commit()
//        Log.i("Fragment_Lifecycle", "after fragmentTransaction commit")
//
//
//        testRxJavaScheduler()
//    }
//
//    override fun loadData() {
//
//    }

//    fun testRxJavaScheduler() {
//
//        Observable.just("Hello World")
////            .observeOn(Schedulers.computation())
//            .map {
//                val result = it.toLowerCase()
//                Log.i("Scheduler", "CurrentThread=${Thread.currentThread()};result=$result")
//                result
//            }
////            .observeOn(Schedulers.io())
//            .map {
//                val result = it + " Now"
//                Log.i("Scheduler", "CurrentThread=${Thread.currentThread()};result=$it")
//                result
//            }
//            .observeOn(Schedulers.single())
////            .subscribeOn(Schedulers.single())
//            .map {
//                val result = it.removeRange(0, 4)
//                Log.i("Scheduler", "CurrentThread=${Thread.currentThread()};result=$it")
//                result
//            }
////            .subscribeOn(Schedulers.io())
//            .subscribe {
//                Log.i("Scheduler", "CurrentThread=${Thread.currentThread()};result=$it")
//            }
//
//    }
}