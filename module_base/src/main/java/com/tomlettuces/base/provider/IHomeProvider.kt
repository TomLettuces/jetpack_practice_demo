package com.tomlettuces.base.provider

interface IHomeProvider : BaseProvider {

    companion object {
        const val HOME_SERVICE = "/home/service"

        const val HOME = "/home/home"
        const val SPLASH = "/home/splash"

    }

    fun toast(string: String)

}