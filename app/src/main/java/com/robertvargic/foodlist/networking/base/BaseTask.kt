package com.robertvargic.foodlist.networking.base

import com.robertvargic.foodlist.networking.ApiService
import retrofit2.Retrofit

abstract class BaseTask(retrofit: Retrofit?) {
    var service: ApiService = retrofit?.create(ApiService::class.java)!!
}