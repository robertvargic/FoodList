package com.robertvargic.foodlist.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.robertvargic.foodlist.R
import com.robertvargic.foodlist.model.Recipe
import kotlinx.android.synthetic.main.activity_food_list.*

class FoodListActivity : AppCompatActivity(), FoodListContract.View {

    lateinit var foodListPresenter: FoodListContract.Presenter

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun initListData(recipeList: List<Recipe>) {
        val adapter = FoodListAdapter(this)
        adapter.setRecipeList(recipeList)
        listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun setPresenter(presenter: FoodListContract.Presenter) {
        foodListPresenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_list)
        setPresenter(FoodListPresenter(this))
        foodListPresenter.getDataFromEndpoint()
    }
}
