package com.dimdimbjg.catalog_compose.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dimdimbjg.catalog_compose.BottomNavContent
import com.dimdimbjg.catalog_compose.BottomNavItem
import com.dimdimbjg.catalog_compose.Cloth
import com.dimdimbjg.catalog_compose.R
import com.dimdimbjg.catalog_compose.ui.theme.*

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Home() {
    //actionbar
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column {
            val allShopList = listOf(
                Cloth(
                    name = stringResource(id = R.string.name1),
                    price = "140.000",
                    R.drawable._1
                ),
                Cloth(
                    name = stringResource(id = R.string.name2),
                    price = "120.000",
                    R.drawable._2
                ),
                Cloth(
                    name = stringResource(id = R.string.name3),
                    price = "125.000",
                    R.drawable._3
                ),
                Cloth(
                    name = stringResource(id = R.string.name4),
                    price = "135.000",
                    R.drawable._4
                ),
                Cloth(
                    name = stringResource(id = R.string.name5),
                    price = "105.000",
                    R.drawable._5
                ),
                Cloth(
                    name = stringResource(id = R.string.name6),
                    price = "125.000",
                    R.drawable._6
                ),
                Cloth(
                    name = stringResource(id = R.string.name7),
                    price = "215.000",
                    R.drawable._7
                ),
                Cloth(
                    name = stringResource(id = R.string.name8),
                    price = "305.000",
                    R.drawable._8
                )
            )

            val navigationItemList = listOf(
                BottomNavItem(
                    "Home",
                    "home",
                    Icons.Default.Home,
                ),
                BottomNavItem(
                    "Wishlist",
                    "wishlist",
                    Icons.Default.Favorite,
                ),
                BottomNavItem(
                    "Notification",
                    "notification",
                    Icons.Default.Notifications,
                ),
                BottomNavItem(
                    "Profile",
                    "profile",
                    Icons.Default.Person,
                )
            )


            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    BottomNavBar(
                        items = navigationItemList,
                        navController = navController
                    )
                    {
                        navController.navigate(it.route)
                    }
                },
                content = {
                    Column() {
                        ActionTopBar()

                        SearchBox()

                        ChipCategory(
                            chips = listOf(
                                "Clothes",
                                "Shoes",
                                "Bags",
                                "Hats",
                                "Accessories",
                                "other"
                            )
                        )

                        ShopList(clothes = allShopList)
                    }

                    Navigation(navController = navController)


                }
            )
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
                fontSize = 40.sp
            )
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                placeholder = { Text("Search your clothes") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(50.dp)),
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search"
                        )

                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TextWhite
                ),
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
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(
            text = "Categories",
            fontSize = 20.sp
        )
        Text(
            text = "View All",
            fontSize = 20.sp,
            color = OrangeYellow2
        )
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
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Chips"
                    )
                    Text(text = chips[it], color = Color.Black)
                }
            }
        }
    }
}


@Composable
fun ClothItem(
    cloth: Cloth
) {
    Box(
        modifier = Modifier
            .padding(1.dp)
            .clickable {
                //handling click
            }
            .padding(4.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = cloth.iconId),
                contentDescription = "Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(text = cloth.name)
            Text(text = "Rp. " + cloth.price)
        }
    }
}

@Composable
fun BottomNavItem(
    item: BottomNavContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { onItemClick }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = item.title,
                color = if (isSelected) activeTextColor else inactiveTextColor
            )
        }
    }
}


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {

        }

        composable("wishlist") {
            WishlistScreen()
        }

        composable("notification") {
            NotificationScreen()
        }

        composable("profile") {
            ProfileScreen()
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    onItemClicked: (BottomNavItem) -> Unit
) {
    val backstageEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = Modifier,
        backgroundColor = TextWhite,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backstageEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClicked(item) },
                selectedContentColor = DarkerButtonBlue,
                unselectedContentColor = BlueViolet1,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        if (item.badgeCount > 0) {
                            BadgeBox(
                                badgeContent = {
                                    Text(text = item.badgeCount.toString())
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = null
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        }
                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun WishlistScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Wishlist to be Implemented Soon")
    }
}

@Composable
fun NotificationScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Notification to be Implemented Soon")
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Profile to be Implemented Soon")
    }
}


@Composable
fun ShopList(clothes: List<Cloth>) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = 100.dp)
    ) {
        StaggeredVerticalGrid(
            modifier = Modifier.padding(12.dp),
        ) {
            clothes.forEach { cloth ->
                ClothItem(cloth = cloth)
            }
        }
    }


}


@Composable
fun StaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    numColumn: Int = 2,
    content: @Composable () -> Unit
) {
    Layout(content = content, modifier = modifier) { measurable, constraints ->

        val columnWidth = (constraints.maxWidth / numColumn)

        val itemConstraints = constraints.copy(maxWidth = columnWidth)

        val columnHeights = IntArray(numColumn) { 0 }

        val placeable = measurable.map { measurable ->
            val column = shortestColumn(columnHeights)
            val placeable = measurable.measure(itemConstraints)
            columnHeights[column] += placeable.height
            placeable
        }


        val height = columnHeights.maxOrNull()
            ?.coerceIn(constraints.minHeight, constraints.maxHeight)
            ?: constraints.minHeight


        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            val columnYPointers = IntArray(numColumn) { 0 }

            placeable.forEach { placeable ->
                val column = shortestColumn(columnYPointers)

                placeable.place(
                    x = columnWidth * column,
                    y = columnYPointers[column],
                )

                columnYPointers[column] += placeable.height

            }
        }

    }

}


private fun shortestColumn(columnHeight: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var columnIndex = 0

    columnHeight.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            columnIndex = index
        }
    }

    return columnIndex
}