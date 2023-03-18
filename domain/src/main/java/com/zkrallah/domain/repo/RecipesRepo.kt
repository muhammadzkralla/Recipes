package com.zkrallah.domain.repo

import com.zkrallah.domain.model.CategoryResponse

interface RecipesRepo {
    fun getRecipesFromRemote(): CategoryResponse
}