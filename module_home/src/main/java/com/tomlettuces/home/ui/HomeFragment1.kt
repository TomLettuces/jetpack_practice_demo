package com.tomlettuces.home.ui

import com.tomlettuces.base.BaseFragment
import com.tomlettuces.base.widget.ArcProgressView
import com.tomlettuces.home.R
import kotlinx.android.synthetic.main.fragment1.*

class HomeFragment1 : BaseFragment() {

    override fun initLayout(): Int {
        return R.layout.fragment1
    }

    override fun initView() {
        var arcProgressView = ArcProgressView(mContext)
        arcProgressView.setProgress(50f)
        custom_container.addView(arcProgressView)
    }

}