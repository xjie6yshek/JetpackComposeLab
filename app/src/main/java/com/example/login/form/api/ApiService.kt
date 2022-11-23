package com.example.login.form.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
interface ApiService {
    @GET("/gh/xjie6yshek/JetpackComposeLab@main/an.json")
    suspend fun getCharacters() : List<com.example.login.form.data.Character>
}