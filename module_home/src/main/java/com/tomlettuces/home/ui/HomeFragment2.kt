package com.tomlettuces.home.ui

import android.text.Html
import com.tomlettuces.base.BaseFragment
import com.tomlettuces.home.R
import kotlinx.android.synthetic.main.fragment2.*

class HomeFragment2 : BaseFragment() {

    override fun initLayout(): Int {
        return R.layout.fragment2
    }

    override fun initView() {
        //基础参考收益：<span style="color:red">980元</span>
        val desc1 = "<span color=\"#FF0000\">" + "10000元" + "</span>"
        val desc2 = "还有 <font color=\"#FF0000\">2</font> 张福利券可同步使用~确认放弃好收益嘛？"
        val text1 = "您账户还有 <font color=\"#FF0000\">3张</font> 福利券，用券出借更有赚哦~"
        val text2 = "真的要放弃这么好的收益么？"
        val text = "出借贴心12月期${"<span style=\"color:red\">xxxyuan</span>"}"
        textview.text = Html.fromHtml(buildString {
            append(text1)
            append("<br></br>")
            append(text2)
        })
    }

}