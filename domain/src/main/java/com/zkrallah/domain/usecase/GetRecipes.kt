package com.zkrallah.domain.usecase

import com.zkrallah.domain.repo.RecipesRepo

class GetRecipes(private val recipesRepo: RecipesRepo) {
    suspend operator fun invoke() = recipesRepo.getRecipesFromRemote()
}