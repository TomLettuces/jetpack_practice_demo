package com.tomlettuces.home.ui

import com.alibaba.android.arouter.facade.annotation.Route
import com.tomlettuces.base.BaseSingleModelViewActivity
import com.tomlettuces.base.provider.IHomeProvider
import com.tomlettuces.home.R
import com.tomlettuces.home.databinding.ActivityRoomTestBinding
import com.tomlettuces.home.viewmodel.RoomViewModel

@Route(path = IHomeProvider.ROOM)
class RoomTestActivity : BaseSingleModelViewActivity<RoomViewModel, ActivityRoomTestBinding>() {


    override fun bindViewModel() {
        mBinding.viewModel = mViewModel
    }

    override fun getLayoutId(): Int = R.layout.activity_room_test

    override fun initView() {

    }

    override fun loadData() {

    }
}