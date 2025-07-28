package com.andikas.nativestarter.core.data.source.remote.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Network(context: Context) {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    // Create a logging interceptor (optional, but very useful for debugging)
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Log request and response bodies
    }

    private val chuckerInterceptor = ChuckerInterceptor.Builder(context)
        .redactHeaders("Authorization")
        .build()

    // Create an OkHttpClient and add the logging interceptor
    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(chuckerInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS) // Optional: Set connection timeout
        .readTimeout(30, TimeUnit.SECONDS)    // Optional: Set read timeout
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient) // Use the custom OkHttpClient
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}