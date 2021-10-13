package com.dimdimbjg.catalog_compose.ui.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.dimdimbjg.catalog_compose.ui.presentation.detail.DetailActivity.Companion.ICON
import com.dimdimbjg.catalog_compose.ui.presentation.detail.DetailActivity.Companion.NAME
import com.dimdimbjg.catalog_compose.ui.presentation.detail.DetailActivity.Companion.PRICE

@Composable
fun DetailScreen() {
    val context = LocalContext.current
    val intent = (context as DetailActivity).intent
    val name = intent.getStringExtra(NAME)
    val price = intent.getStringExtra(PRICE)
    val icon = intent.getIntExtra(ICON, 0)
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color.Red)
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "big image",
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopStart,
                    modifier = Modifier.fillMaxWidth()
                )
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    val (image1, image2, image3, icon1, icon2, icon3) = createRefs()

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier
                            .padding(top = 10.dp, start = 10.dp)
                            .constrainAs(icon1) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                            }
                            .size(24.dp),
                        tint = Color.White
                    )

                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "favorite",
                        modifier = Modifier
                            .padding(top = 10.dp, end = 10.dp)
                            .constrainAs(icon2) {
                                end.linkTo(icon3.start)
                                top.linkTo(parent.top)
                            }
                            .size(24.dp),
                        tint = Color.Red
                    )

                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "back",
                        modifier = Modifier
                            .padding(top = 10.dp, end = 10.dp)
                            .constrainAs(icon3) {
                                end.linkTo(parent.end)
                                top.linkTo(parent.top)
                            }
                            .size(24.dp),
                        tint = Color.White
                    )

                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = "image3",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopStart,
                        modifier = Modifier
                            .padding(bottom = 10.dp, end = 10.dp)
                            .constrainAs(image3) {
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                            .size(50.dp, 50.dp)
                            .clip(CircleShape)
                    )

                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = "image2",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .padding(bottom = 10.dp, end = 10.dp)
                            .constrainAs(image2) {
                                end.linkTo(parent.end)
                                bottom.linkTo(image3.top)
                            }
                            .size(50.dp, 50.dp)
                            .clip(CircleShape)


                    )

                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = "image1",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.BottomEnd,
                        modifier = Modifier
                            .padding(bottom = 10.dp, end = 10.dp)
                            .constrainAs(image1) {
                                end.linkTo(parent.end)
                                bottom.linkTo(image2.top)
                            }
                            .size(50.dp, 50.dp)
                            .clip(CircleShape)

                    )

                }
            }
            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .weight(1.2f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    DetailScreen()
}