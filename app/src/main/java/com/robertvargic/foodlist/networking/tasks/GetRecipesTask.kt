package com.robertvargic.foodlist.networking.tasks

import android.util.Log
import com.robertvargic.foodlist.model.SearchResponse
import com.robertvargic.foodlist.networking.base.BaseTask
import com.robertvargic.foodlist.networking.base.ServerTask
import com.robertvargic.foodlist.networking.base.TaskListener
import retrofit2.*

class GetRecipesTask(retrofit: Retrofit?) : BaseTask(retrofit), ServerTask<SearchResponse> {
    override fun execute(listener: TaskListener<SearchResponse>) {
        listener.onPreExecute()
        val call = service.getRecipes()

        call.enqueue(object : Callback<SearchResponse> {
            override fun onFailure(call: Call<SearchResponse>?, t: Throwable?) {
                t?.run {
                    listener.onError(this)
                    Log.e("error", t.toString())
                }
            }

            override fun onResponse(call: Call<SearchResponse>?, response: Response<SearchResponse>?) {
                response?.body()?.run {
                    listener.onSucess(this)
                    Log.e("body", response?.body()?.toString())
                }
                response?.body()?.run {
                    listener.onError(HttpException(response))
                    Log.e("body", response?.body()?.toString())
                }
            }

        })
    }
}