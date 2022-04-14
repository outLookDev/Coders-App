package com.hudazamov.myquran.map

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hudazamov.myquran.network.APIClient
import com.hudazamov.myquran.network.PlaceAPI
import com.hudazamov.myquran.pojo.Mosque
import com.hudazamov.myquran.pojo.Result

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapViewModel : ViewModel() {

    val mosques = MutableLiveData<List<com.hudazamov.myquran.pojo.Result>>()

    fun getNearByMosques(type:String, location:String, apiKey:String): MutableLiveData<List<Result>> {
        val apiClient = APIClient()
        apiClient.getInstance()
            .create(PlaceAPI::class.java)
            .getNearbyMosques(type,location,3000,apiKey).enqueue(object : Callback<Mosque> {
                override fun onResponse(call: Call<Mosque>, response: Response<Mosque>) {
                    if(response.isSuccessful) {
                        mosques.value = response.body()?.results
                    }
                }

                override fun onFailure(call: Call<Mosque>, t: Throwable) {
                }
            })
        return mosques
    }
}