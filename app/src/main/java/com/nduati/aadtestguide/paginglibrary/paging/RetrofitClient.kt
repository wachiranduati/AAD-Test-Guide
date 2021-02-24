package com.nduati.aadtestguide.paginglibrary.paging

import com.google.gson.JsonElement
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    private val service : API

    companion object {
        //1
        const val BASE_URL = "https://api.stackexchange.com/2.2/"
    }

    init {
        // 2
        val retrofit = Retrofit.Builder()
            // 1
            .baseUrl(BASE_URL)
            //3
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //4
        service = retrofit.create(API::class.java)
    }


    fun getAnswers(page : Int, pagesize : Int, site : String) : Call<StackApiResponse> {
        return service.getAnswers(page, pagesize, site)
    }

}