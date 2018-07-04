package com.robertvargic.foodlist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.robertvargic.foodlist.R
import com.robertvargic.foodlist.model.Recipe
import com.squareup.picasso.Picasso

class FoodListAdapter(context: Context) : BaseAdapter() {

    private lateinit var recipeList: List<Recipe>
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    fun setRecipeList(recipes: List<Recipe>) {
        recipeList = recipes
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val viewHodler: ListRowHolder
        if (convertView == null) {
            view = this.inflater.inflate(R.layout.list_item_recipe, parent, false)
            viewHodler = ListRowHolder(view)
            view.tag = viewHodler
        } else {
            view = convertView
            viewHodler = view.tag as ListRowHolder
        }

        viewHodler.title.text = recipeList[position].title
        viewHodler.rank.text = recipeList[position].rank
        Picasso.get().load(recipeList[position].imageUrl).into(viewHodler.imageView)

        return view
    }

    override fun getItem(position: Int): Any {
        return recipeList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return recipeList.size
    }

    private class ListRowHolder(view: View?) {
        val title: TextView = view?.findViewById(R.id.title) as TextView
        val rank: TextView = view?.findViewById(R.id.socialRank) as TextView
        val imageView: ImageView = view?.findViewById(R.id.imageView) as ImageView

    }
}