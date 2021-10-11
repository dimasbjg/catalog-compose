package com.dimdimbjg.catalog_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dimdimbjg.catalog_compose.R
import com.dimdimbjg.catalog_compose.ui.theme.BlueViolet1
import com.dimdimbjg.catalog_compose.ui.theme.ButtonBlue
import com.dimdimbjg.catalog_compose.ui.theme.DarkerButtonBlue

@Composable
fun Home() {
    //actionbar
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column {
            ActionTopBar()
            SearchBox()
            ChipCategory(chips = listOf("Clothes", "Shoes", "Bags", "Hats", "Accessories", "other"))
        }
    }
}


@Composable
fun ActionTopBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun SearchBox() {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(BlueViolet1)
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        var text by rememberSaveable { mutableStateOf("") }
        Column {
            Text(
                text = "Find the BEST clothes for you",
                color = DarkerButtonBlue,
                fontSize = 50.sp
            )
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                placeholder = { Text("Search your clothes")},
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(50.dp)),
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search")
                        
                    }
                }
            )

        }
    }
}

@Composable
fun ChipCategory(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(50.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = Color.Black)
            }
        }
    }
}

