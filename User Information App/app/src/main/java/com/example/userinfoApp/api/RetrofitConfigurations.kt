package com.example.userinfoApp.api
import android.telecom.Call
import com.example.userinfoApp.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService{
    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users/{userId}")
    fun getUser(@Path ("userId") id:String):Call<User>

    companion object {

        val API_URL= "https://jsonplaceholder.typicode.com"

        fun create():UserApiService
        {
           val retrofit=Retrofit.Builder()
               .addConverterFactory(GsonConverterFactory.create())
               .baseUrl(API_URL)
               .build()
            return retrofit.create(UserApiService::class.java)

        }
    }
}



