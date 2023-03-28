package com.zkrallah.recipes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zkrallah.domain.model.CategoryResponse
import com.zkrallah.domain.usecase.GetRecipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(private val getRecipesUseCase: GetRecipes) :
    ViewModel() {

    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val categories: StateFlow<CategoryResponse?> = _categories

    fun getRecipes() {
        viewModelScope.launch {
            try {
                _categories.value = getRecipesUseCase()
            } catch (e: Exception) {
                Log.e("RecipesViewModel", e.message.toString())
            }
        }
    }
}