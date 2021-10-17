package com.dimdimbjg.catalog_compose.ui.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dimdimbjg.catalog_compose.data.Repository
import com.dimdimbjg.catalog_compose.data.source.local.entity.Cloth

class DetailViewModel(private val repository: Repository) : ViewModel() {


    fun checkFavorite(cloth: Cloth): LiveData<Boolean> {
        return repository.checkFavorite(cloth)
    }

    fun insert(cloth: Cloth) {
        repository.insert(cloth)
    }

    fun delete(cloth: Cloth) {
        repository.delete(cloth)
    }

}