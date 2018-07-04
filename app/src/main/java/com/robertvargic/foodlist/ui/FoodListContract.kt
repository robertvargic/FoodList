package com.robertvargic.foodlist.ui

import com.robertvargic.foodlist.model.Recipe
import com.robertvargic.foodlist.ui.base.BasePresenter
import com.robertvargic.foodlist.ui.base.BaseView

interface FoodListContract {

    interface View : BaseView<Presenter> {
        fun showProgress()
        fun hideProgress()
        fun initListData(recipeList: List<Recipe>)
    }

    interface Presenter : BasePresenter {
        fun getDataFromEndpoint()
    }
}