package com.example.admin.mapkt.di.modules

import com.example.admin.mapkt.data.Server
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    private fun getLoggingInterceptor(): HttpLoggingInterceptor = with(HttpLoggingInterceptor()) {
        level = HttpLoggingInterceptor.Level.BODY
        this
    }

    private fun getRequestInterceptor(): Interceptor = Interceptor { chain ->
        val requestBody = chain.request()
                .newBuilder()
                .header("X-Yandex-API-Key", "6539ded7-68e4-4299-8725-39fe4bf8ead5")
                .build()
        chain.proceed(requestBody)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = with(OkHttpClient.Builder()) {
        addInterceptor(getRequestInterceptor())
        addInterceptor(getLoggingInterceptor())
        build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
            with(Retrofit.Builder()) {
                baseUrl("https://api.weather.yandex.ru/")
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                addConverterFactory(GsonConverterFactory.create())
                client(client)
                build()
            }

    @Provides
    @Singleton
    fun provideServer(retrofit: Retrofit): Server = retrofit.create(Server::class.java)
}