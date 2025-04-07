package com.kiy.report.core.designsystem.theme.components.contents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiy.report.core.model.MusinsaProducts


@Composable
fun HorizontalScrollTypeContent(
    modifier: Modifier = Modifier,
    items: List<MusinsaProducts>
) {
    Box(
        modifier = modifier
    ) {
        val itemSize = items.size
        LazyRow(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp
            ),
        ) {
            items(
                count = itemSize,
                key =  { index -> items[index].hashCode() }
            ) {
                ProductItem(
                    modifier = Modifier,
                    brandName = "",
                    imageUrl = "",
                    price = "",
                    saleRate = 0,
                    hasCoupon = false
                )
            }
        }
    }
}

@Preview
@Composable
private fun previewHorizontalScroll() {
    HorizontalScrollTypeContent(
        items = listOf(
            MusinsaProducts(),
            MusinsaProducts(),
            MusinsaProducts(),
            MusinsaProducts(),
            MusinsaProducts(),
            MusinsaProducts(),
            MusinsaProducts(),
        )
    )
}