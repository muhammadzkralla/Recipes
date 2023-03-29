package com.zkrallah.recipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.zkrallah.recipes.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[RecipesViewModel::class.java]

        viewModel.getRecipes()
        val adapter = RecipesAdapter()
        val recycler = binding.categoryRv

        lifecycleScope.launch {
            viewModel.categories.collect {
                adapter.submitList(it?.categories)
                recycler.adapter = adapter
            }
        }
    }
}