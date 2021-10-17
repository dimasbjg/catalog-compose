package com.dimdimbjg.catalog_compose.ui.presentation.detail

import android.graphics.drawable.Drawable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.amulyakhare.textdrawable.TextDrawable
import com.dimdimbjg.catalog_compose.R
import com.dimdimbjg.catalog_compose.data.source.local.entity.Cloth
import com.dimdimbjg.catalog_compose.ui.presentation.detail.DetailActivity.Companion.ICON
import com.dimdimbjg.catalog_compose.ui.presentation.detail.DetailActivity.Companion.ID
import com.dimdimbjg.catalog_compose.ui.presentation.detail.DetailActivity.Companion.NAME
import com.dimdimbjg.catalog_compose.ui.presentation.detail.DetailActivity.Companion.PRICE
import com.dimdimbjg.catalog_compose.ui.theme.BlueViolet1
import com.dimdimbjg.catalog_compose.ui.theme.OrangeYellow1
import com.dimdimbjg.catalog_compose.viewmodel.ViewModelFactory
import com.google.accompanist.drawablepainter.rememberDrawablePainter

@Composable
fun DetailScreen() {
    val context = LocalContext.current
    val viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory.getInstance(context)
    )
    val intent = (context as DetailActivity).intent
    val id = intent.getIntExtra(ID, 0)
    val name = intent.getStringExtra(NAME)
    val price = intent.getStringExtra(PRICE)
    val icon = intent.getIntExtra(ICON, 0)
    val lorem = context.resources.getString(R.string.lorem)
    lateinit var cloth: Cloth

    if (name != null && price != null) {
        cloth = Cloth(id, name, price, icon)
    }

    val isFavorite by viewModel.checkFavorite(cloth).observeAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(30.dp))
                    .background(color = Color.Red)
            ) {

                var imageSize by remember { mutableStateOf(IntSize.Zero) }
                val gradient = Brush.verticalGradient(
                    colors = listOf(Transparent, Color.Black),
                    startY = imageSize.height.toFloat()/2,
                    endY = imageSize.height.toFloat()
                )


                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "big image",
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned {
                            imageSize = it.size
                        }
                )

                Box(modifier = Modifier
                    .matchParentSize()
                    .background(gradient))

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

//                    val imgFavorite = if(isFavorite == true) Icons.Default.Favorite else Icons.Default.FavoriteBorder
                    val fav = false
                    val imgFavorite = if(fav) Icons.Default.Favorite else Icons.Default.FavoriteBorder


                    Icon(
                        imageVector = imgFavorite,
                        contentDescription = "favorite",
                        modifier = Modifier
                            .padding(top = 10.dp, end = 10.dp)
                            .constrainAs(icon2) {
                                end.linkTo(icon3.start)
                                top.linkTo(parent.top)
                            }
                            .size(24.dp)
                            .clickable {
//                                if(isFavorite == false) Icons.Default.Favorite else Icons.Default.FavoriteBorder

                                if(!fav) Icons.Default.Favorite else Icons.Default.FavoriteBorder


                            },
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
            Spacer(modifier = Modifier
                .height(15.dp)
                .background(color = Transparent))
            Box(
                modifier = Modifier
                    .padding(end = 15.dp, start = 15.dp, bottom = 15.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box {
                            Row {
                                if (name != null) {
                                    val iconName = TextDrawable.builder()
                                        .buildRound(
                                            name[0].toString(),
                                            BlueViolet1.hashCode()
                                        ) as Drawable
                                    Image(
                                        painter = rememberDrawablePainter(drawable = iconName),
                                        contentDescription = "icon",
                                        modifier = Modifier.size(80.dp)
                                    )
                                }
                                Column(
                                    modifier = Modifier
                                        .height(80.dp)
                                        .padding(start = 15.dp),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "Ucito appaerl",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text("Official Store", fontSize = 15.sp)
                                }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .background(color = Color.Transparent)
                                .border(
                                    width = 0.01.dp,
                                    color = Color.Green,
                                    shape = RoundedCornerShape(50.dp)
                                )
                                .padding(0.dp)
                                .padding(15.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "check",
                                    tint = Color.Green,
                                    modifier = Modifier.padding(5.dp)
                                )
                                Text(text = "Following", color = Color.Green)
                            }
                        }
                    }
                    if (name != null) {
                        Text(
                            text = name,
                            fontSize = 30.sp,
                            softWrap = true,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 15.dp, bottom = 15.dp, end = 50.dp)
                        )
                    }
                    ExpandableText(text = lorem)
                    Text(
                        text = "Select Size",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 30.dp, bottom = 15.dp)
                    )
                    ChipCategory(chips = listOf("S", "M", "L", "XL"))
                    Button(
                        onClick = {
                            //TO DO//
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
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 15.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(2f),
                                contentAlignment = Alignment.Center
                            ) {
                                if (price != null) Text(
                                    text = "Rp $price",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                            Box(
                                modifier = Modifier.weight(3f),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Add to cart",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ChipCategory(chips: List<String>) {
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
                    .clip(CircleShape)
                    .background(
                        if (selectedChipIndex == it) OrangeYellow1
                        else Color.Transparent
                    )
                    .border(0.1.dp, OrangeYellow1, CircleShape)
                    .padding(15.dp)
                    .size(40.dp)
                    .wrapContentSize(Alignment.Center)
            ) {
                Row {
                    Text(
                        text = chips[it],
                        color = if (selectedChipIndex == it) Color.White else Color.Black,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ExpandableText(
    text: String,
    modifier: Modifier = Modifier,
    minimizedMaxLines: Int = 2,
) {
    var cutText by remember(text) { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }
    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    val seeMoreSizeState = remember { mutableStateOf<IntSize?>(null) }
    val seeMoreOffsetState = remember { mutableStateOf<Offset?>(null) }


    val textLayoutResult = textLayoutResultState.value
    val seeMoreSize = seeMoreSizeState.value
    val seeMoreOffset = seeMoreOffsetState.value

    LaunchedEffect(text, expanded, textLayoutResult, seeMoreSize) {
        val lastLineIndex = minimizedMaxLines - 1
        if (!expanded && textLayoutResult != null && seeMoreSize != null
            && lastLineIndex + 1 == textLayoutResult.lineCount
            && textLayoutResult.isLineEllipsized(lastLineIndex)
        ) {
            var lastCharIndex = textLayoutResult.getLineEnd(lastLineIndex, visibleEnd = true) + 1
            var charRect: Rect
            do {
                lastCharIndex -= 1
                charRect = textLayoutResult.getCursorRect(lastCharIndex)
            } while (
                charRect.left > textLayoutResult.size.width - seeMoreSize.width
            )
            seeMoreOffsetState.value = Offset(charRect.left, charRect.bottom - seeMoreSize.height)
            cutText = text.substring(startIndex = 0, endIndex = lastCharIndex)
        }
    }

    Box(modifier) {
        Text(
            text = cutText ?: text,
            maxLines = if (expanded) Int.MAX_VALUE else minimizedMaxLines,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { textLayoutResultState.value = it },
        )
        if (!expanded) {
            val density = LocalDensity.current
            Text(
                "... See more",
                fontWeight = FontWeight.Bold,
                color = OrangeYellow1,
                onTextLayout = { seeMoreSizeState.value = it.size },
                modifier = Modifier
                    .then(
                        if (seeMoreOffset != null)
                            Modifier.offset(
                                x = with(density) { seeMoreOffset.x.toDp() },
                                y = with(density) { seeMoreOffset.y.toDp() },
                            )
                        else
                            Modifier
                    )
                    .clickable {
                        expanded = true
                        cutText = null
                    }
                    .alpha(if (seeMoreOffset != null) 1f else 0f)
            )
        }
    }
}