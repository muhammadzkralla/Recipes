package com.zkrallah.domain.repo

import com.zkrallah.domain.model.CategoryResponse

interface RecipesRepo {
    suspend fun getRecipesFromRemote(): CategoryResponse
}