package com.tomlettuces.home.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.tomlettuces.base.StatusBarUtils
import com.tomlettuces.base.provider.IHomeProvider
import com.tomlettuces.home.R

@Route(path = IHomeProvider.COLOR)
class ColorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
        StatusBarUtils.setColor(this, resources.getColor(R.color.colorWhite))
//        StatusBarUtils.setTransparent(this)
//        StatusBarUtils.setTextDark(this, true)
    }
}