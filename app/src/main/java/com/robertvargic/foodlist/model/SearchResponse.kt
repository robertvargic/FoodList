package com.robertvargic.foodlist.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(@SerializedName("count") val count: Int,
                          @SerializedName("recipes") val recipes: MutableList<Recipe>) {
}