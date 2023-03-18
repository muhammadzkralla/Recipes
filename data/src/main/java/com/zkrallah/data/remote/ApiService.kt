package com.zkrallah.data.remote

import com.zkrallah.domain.model.CategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    fun getRecipes(): CategoryResponse
}