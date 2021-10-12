package com.dimdimbjg.catalog_compose.ui.presentation.getstarted

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.dimdimbjg.catalog_compose.R
import com.dimdimbjg.catalog_compose.ui.presentation.home.HomeActivity

@Composable
fun GetStarted() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable._1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val (whiteBox) = createRefs()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .constrainAs(whiteBox) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clip(RoundedCornerShape(15.dp))
                .background(color = Color.White)
        ) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(15.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(color = Color.White)
                    .padding(35.dp)
            ) {
                Text(
                    text = "Find your BEST outfit and look great",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = Bold
                )
                Text(
                    text = "Shop here and get benefits and world quality goods",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 15.dp)
                )
                val context = LocalContext.current
                Button(
                    onClick = {
                        context.startActivity(Intent(context, HomeActivity::class.java))
                    },
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(50.dp)),
                    contentPadding = PaddingValues(
                        top = 15.dp,
                        bottom = 15.dp
                    )
                ) {
                    Text(text = "Get started")
                }
            }
        }
    }
}