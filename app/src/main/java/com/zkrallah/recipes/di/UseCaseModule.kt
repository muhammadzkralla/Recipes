package com.zkrallah.recipes.di

import com.zkrallah.domain.repo.RecipesRepo
import com.zkrallah.domain.usecase.GetRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(recipesRepo: RecipesRepo): GetRecipes{
        return GetRecipes(recipesRepo)
    }
}