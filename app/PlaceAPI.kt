package com.hudazamov.myquran.network

import com.hudazamov.myquran.pojo.Mosque
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceAPI {

    @GET("place/nearbysearch/json")
    fun getNearbyMosques(@Query("type") type: String,
                        @Query("location") location: String,
                        @Query("radius") radius: Int,
                        @Query("key") key: String): Call<Mosque>
}