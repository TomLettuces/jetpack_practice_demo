package com.tomlettuces.user

import android.text.TextUtils
import androidx.databinding.ViewDataBinding
import com.alibaba.android.arouter.facade.annotation.Route
import com.tomlettuces.base.BaseActivity
import com.tomlettuces.base.ServiceManager
import com.tomlettuces.base.provider.IUserProvider
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_login.*
import java.beans.PropertyChangeListener
import java.util.concurrent.TimeUnit

@Route(path = IUserProvider.LOGIN)
class LoginActivity : BaseActivity<ViewDataBinding>() {

    lateinit var name: String
    lateinit var user: Person

    val mDisposable = CompositeDisposable()

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun initView() {
        val userName = intent.getStringExtra("name")

        name = when {
            TextUtils.isEmpty(userName) -> "Tom"
            else -> userName
        }
        et_login_account?.setText(name)
        btn_back.setOnClickListener {finish()}
        btn_login.setOnClickListener {
            ServiceManager.getHomeProvider().toast("登录成功")
        }

        user = Person(name, 18, 1000)
        user.addPropertyChangeListener(
            PropertyChangeListener {
                tv_person_info.text = "Property ${it.propertyName} changed " + "from ${it.oldValue} to ${it.newValue}"
            }
        )

    }

    override fun loadData() {
        mDisposable.add(
            Observable.timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    user.age = 19
                }
        )

    }

    override fun onDestroy() {
        super.onDestroy()
        mDisposable.dispose()
    }

}
