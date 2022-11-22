package com.example.login.form.api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val retrofit: Retrofit
    init {
        val builder = Retrofit.Builder()
            .baseUrl("https://cdn.jsdelivr.net/")
            .addConverterFactory(GsonConverterFactory.create())

//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
//        okHttpClient.addInterceptor(loggingInterceptor)
        okHttpClient.addInterceptor { chain ->
            val request: Request = chain.request().newBuilder().build()
            chain.proceed(request)
        }
        okHttpClient.connectTimeout(1, java.util.concurrent.TimeUnit.MINUTES).build()

        retrofit = builder.client(okHttpClient.build())
            .build()
    }

    fun getAuthService() : ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
