package com.kiy.report.core.designsystem.theme.components.contents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kiy.report.core.model.GoodsData

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 8.
 */

@Composable
fun ScrollTypeComponent(
    modifier: Modifier = Modifier,
    items: List<GoodsData> = emptyList(),
    maxRow: Int = 3,
    onItemClick: (GoodsData) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(maxRow),
        modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            items = items,
            key = { it.hashCode() }
        ) { item ->
            ProductItem(
                brandName = item.brandName,
                imageUrl = item.thumbnailURL,
                price = item.price.toString(),
                saleRate = item.saleRate,
                hasCoupon = item.hasCoupon,
                onClick = {
                    onItemClick(item)
                }
            )
        }
    }
}
