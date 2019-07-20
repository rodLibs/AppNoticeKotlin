package com.example.appnewskotlin.data.network
import android.content.Context
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit


class Network (private var context: Context) {


    private var TIME_OUT: Long = 5000
    private var URL: String = " https://g1.globo.com/dynamo/"









    fun getNews(query_news: String, cb: CallbackNetwork) {
        val client = OkHttpClient.Builder()
            .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS).build()

        val request = Request.Builder()
            .url(URL + query_news)
            .get()
            .build()

        val call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                if (!call.isCanceled()) {
                    cb.onError(0,e.message)
                }
            }
            override fun onResponse(call: Call, response: Response) {
                val value = response.body?.string()
                val code = response.code
                if (response.isSuccessful) {
                    cb.onSucess(code, value)
                } else {
                    cb.onError(code, value)
                }
            }
        })
    }
}