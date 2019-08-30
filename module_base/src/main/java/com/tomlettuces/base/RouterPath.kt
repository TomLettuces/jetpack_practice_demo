package com.tomlettuces.base

class RouterPath {

    companion object {
        const val HOME = "/home/home"
        const val SPLASH = "/home/splash"

        const val LOGIN = "/user/login"
        const val REGISTER = "/user/register"

        // 相当于Java中的静态方法
        fun work() {
            println("静态方法")
        }
    }


}