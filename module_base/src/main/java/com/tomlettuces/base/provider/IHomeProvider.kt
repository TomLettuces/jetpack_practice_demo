package com.tomlettuces.base.provider

interface IHomeProvider : BaseProvider {

    companion object {
        const val HOME_SERVICE = "/home/service"

        const val HOME = "/home/home"
        const val SPLASH = "/home/splash"
        const val ROOM = "/home/room"
        const val COLOR = "/home/color"

    }

    fun toast(string: String)

}