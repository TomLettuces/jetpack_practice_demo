package com.tomlettuces.base.provider

interface IUserProvider : BaseProvider {

    companion object {
        // service
        const val USER_SERVICE = "/user/service"

        const val LOGIN = "/user/login"
        const val REGISTER = "/user/register"
    }

    fun login()

}