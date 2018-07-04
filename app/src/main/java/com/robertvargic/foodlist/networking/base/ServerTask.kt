package com.robertvargic.foodlist.networking.base

interface ServerTask<R> {
    fun execute(listener: TaskListener<R>)
}