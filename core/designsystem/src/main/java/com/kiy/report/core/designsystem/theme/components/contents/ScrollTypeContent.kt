package com.kiy.report.core.designsystem.theme.components.contents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kiy.report.core.model.MusinsaUiData

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 8.
 */

@Composable
fun ScrollTypeComponent(
    modifier: Modifier = Modifier
        .heightIn(max = 400.dp)
        .wrapContentHeight(),
    items: List<MusinsaUiData.ScrollGoodsData> = emptyList(),
    onItemClick: (MusinsaUiData.ScrollGoodsData) -> Unit = {}
) {
    LazyRow(
        modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = items,
            key = { it.hashCode() }
        ) { item ->
            ProductItem(
                brandName = item.brandName,
                imageUrl = item.thumbnailURL,
                price = item.getPriceText(),
                saleRate = item.saleRate,
                hasCoupon = item.hasCoupon,
                onClick = {
                    onItemClick(item)
                }
            )
        }
    }
}
