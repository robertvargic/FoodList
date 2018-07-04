package com.robertvargic.foodlist.networking.base

interface TaskListener<T> {
    fun onPreExecute()
    fun onSucess(result: T)
    fun onError(error: Throwable)
}