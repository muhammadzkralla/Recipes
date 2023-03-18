package com.zkrallah.data.repo

import com.zkrallah.data.remote.ApiService
import com.zkrallah.domain.model.CategoryResponse
import com.zkrallah.domain.repo.RecipesRepo

class RecipesRepoImpl(private val apiService: ApiService): RecipesRepo {
    override fun getRecipesFromRemote(): CategoryResponse = apiService.getRecipes()

}