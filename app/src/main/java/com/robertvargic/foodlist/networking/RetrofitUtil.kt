package com.robertvargic.foodlist.networking

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtil {

    companion object {

        private const val BASE_URL = "http://food2fork.com/"
        var retrofit: Retrofit? = null


        fun createRetrofit(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(getGson()))
                        .client(okHttpClient())
                        .build()
            }
            return retrofit
        }

        private fun getGson(): Gson {
            return getCommonBuilder()
                    .create()
        }

        private fun getCommonBuilder(): GsonBuilder {
            return GsonBuilder()
        }

        private fun provideLoggingInterceptor(): HttpLoggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        private fun okHttpClient(): OkHttpClient =
                OkHttpClient.Builder().apply {
                    addInterceptor(provideLoggingInterceptor())
                }.build()
    }
}