package com.example.appnewskotlin.data.network


interface CallbackNetwork {

    fun onSucess(code: Int, response: String?)
    fun onError(code: Int, error: String?)
}