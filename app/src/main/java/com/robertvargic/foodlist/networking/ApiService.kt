package com.robertvargic.foodlist.networking

import com.robertvargic.foodlist.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/api/search/?key=291b7e7495709e9263fc1df6f88b0612")
    fun getRecipes(): Call<SearchResponse>
}