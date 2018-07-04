package com.robertvargic.foodlist.model

import com.google.gson.annotations.SerializedName

data class Recipe(@SerializedName("title") val title: String,
                  @SerializedName("social_rank") val rank: String,
                  @SerializedName("image_url") val imageUrl: String) {
}