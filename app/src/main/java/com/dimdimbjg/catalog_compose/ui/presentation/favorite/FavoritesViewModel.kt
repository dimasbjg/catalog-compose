package com.dimdimbjg.catalog_compose.ui.presentation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dimdimbjg.catalog_compose.data.Repository
import com.dimdimbjg.catalog_compose.data.source.local.entity.Cloth

class FavoritesViewModel(private val repository: Repository) : ViewModel() {

    fun getAll(): LiveData<List<Cloth>> {
        return repository.getAll()
    }
}