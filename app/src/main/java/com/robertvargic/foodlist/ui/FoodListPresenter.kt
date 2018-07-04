package com.robertvargic.foodlist.ui

import android.util.Log
import com.robertvargic.foodlist.model.SearchResponse
import com.robertvargic.foodlist.networking.RetrofitUtil
import com.robertvargic.foodlist.networking.base.TaskListener
import com.robertvargic.foodlist.networking.tasks.GetRecipesTask

class FoodListPresenter(private val foodListView: FoodListContract.View): FoodListContract.Presenter {

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDataFromEndpoint() {
        val getRecipesTask = GetRecipesTask(RetrofitUtil.createRetrofit())

        getRecipesTask.execute(object: TaskListener<SearchResponse> {
            override fun onPreExecute() {
                foodListView.showProgress()
            }

            override fun onSucess(result: SearchResponse) {
                foodListView.initListData(result.recipes)
                foodListView.hideProgress()
            }

            override fun onError(error: Throwable) {
                Log.e("Get Recipe list: ", error.toString())
            }

        })
    }
}