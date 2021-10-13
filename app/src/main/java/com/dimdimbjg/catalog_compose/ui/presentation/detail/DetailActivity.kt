package com.dimdimbjg.catalog_compose.ui.presentation.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.dimdimbjg.catalog_compose.Cloth
import com.dimdimbjg.catalog_compose.ui.presentation.detail.ui.theme.CatalogcomposeTheme

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DetailScreen()
                }
            }
        }
    }

    companion object {
        const val NAME = "name"
        const val PRICE = "price"
        const val ICON = "icon"
    }

}