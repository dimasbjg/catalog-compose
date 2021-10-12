package com.dimdimbjg.catalog_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dimdimbjg.catalog_compose.ui.Home
import com.dimdimbjg.catalog_compose.ui.presentation.getstarted.GetStarted
import com.dimdimbjg.catalog_compose.ui.theme.CatalogcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatalogcomposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    GetStarted()
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetStarted()
}