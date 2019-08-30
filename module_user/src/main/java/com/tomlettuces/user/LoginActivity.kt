package com.tomlettuces.user

import android.databinding.ViewDataBinding
import android.text.TextUtils
import com.alibaba.android.arouter.facade.annotation.Route
import com.tomlettuces.base.BaseActivity
import com.tomlettuces.base.ServiceManager
import com.tomlettuces.base.provider.IUserProvider
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = IUserProvider.LOGIN)
class LoginActivity : BaseActivity<ViewDataBinding>() {

    lateinit var name: String

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
    }

    override fun loadData() {

    }

}
