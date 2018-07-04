package com.robertvargic.foodlist.ui.base

interface BaseView<in T> {
    fun setPresenter(presenter: T)
}