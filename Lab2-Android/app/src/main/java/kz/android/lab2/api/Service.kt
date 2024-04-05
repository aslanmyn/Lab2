package kz.android.lab2.api

import kz.android.lab2.model.CatBreed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Service {
    @Headers("X-Api-Key:vsxknAI2T4UtdnXCs5tZAQ==4i4LhQtXHV5NusUB")
    @GET("cats")
    fun getCatBreedByName(@Query("name") name: String): Call<List<CatBreed>>
}