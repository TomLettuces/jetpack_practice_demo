package com.tomlettuces.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import java.util.concurrent.TimeUnit

class HomeViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    private val _phone = MutableLiveData<Int>()

    val name: LiveData<String> = _name
    val phone: LiveData<Int> = _phone

    init {
        _name.value = "Tom"
        _phone.value = 1371823812
    }

    fun changeData() {
        Observable.timer(3000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                _name.value = "Google"
            })

    }

}