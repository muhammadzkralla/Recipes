package com.zkrallah.recipes.di

import com.zkrallah.data.remote.ApiService
import com.zkrallah.data.repo.RecipesRepoImpl
import com.zkrallah.domain.repo.RecipesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): RecipesRepo{
        return RecipesRepoImpl(apiService)
    }
}