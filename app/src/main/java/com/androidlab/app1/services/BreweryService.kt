package com.androidlab.app1.services

import com.androidlab.app1.models.Brewery
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BreweryService {

    @GET("/breweries")
    fun getBreweries(): Call<List<Brewery?>?>?

    @GET("/breweries/{obdb-id}")
    fun getBreweryById(@Path(value="obdb-id") id: String): Call<Brewery?>?

}