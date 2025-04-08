package com.kiy.report.core.designsystem.theme.components.contents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kiy.report.core.designsystem.theme.components.MusinsaImage
import com.kiy.report.core.model.MusinsaUiData
import kotlin.math.max

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 8.
 */

@Composable
fun StyleTypeComponent(
    modifier: Modifier = Modifier,
    maxVisibleCount:Int = 6,
    styleTypeDataList: List<MusinsaUiData.StyleTypeData>,
    onItemClick: (MusinsaUiData.StyleTypeData) -> Unit
) {
    val size = styleTypeDataList.size
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            if (styleTypeDataList.isNotEmpty()) {
                ImageGridItem(
                    modifier = Modifier
                        .weight(2f)
                        .padding(4.dp)
                        .aspectRatio(1f / 1.3f),
                    product =  styleTypeDataList[0],
                    onItemClick = onItemClick,
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                // 이미지 1, 2
                if (size > 1) {
                    ImageGridItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        product =  styleTypeDataList[1],
                        onItemClick = onItemClick,
                    )
                }

                if (size > 2) {
                    ImageGridItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        product =  styleTypeDataList[2],
                        onItemClick = onItemClick,
                    )
                }
            }
        }

        val extraItems = styleTypeDataList.drop(3)
        extraItems.take(maxVisibleCount - 3).chunked(3).forEachIndexed { index, styleTypeData ->
            Row(modifier = Modifier.fillMaxWidth()) {
                styleTypeData.forEach { item ->
                    ImageGridItem(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .aspectRatio(1f / 1.3f), // 세로로 길게
                        product =  item,
                        onItemClick = onItemClick,
                    )
                }
                if (styleTypeData.size < 3) {
                    repeat(3 - styleTypeData.size) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f / 2f),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ImageGridItem(
    modifier: Modifier = Modifier,
    product: MusinsaUiData.StyleTypeData,
    onItemClick: (MusinsaUiData.StyleTypeData) -> Unit
) {
    Card(
        modifier = modifier
            .aspectRatio(1F / 1.3F)
            .clickable(onClick = {
                onItemClick(product)
            }),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        MusinsaImage.NetworkImage(
            product.thumbnailUrl,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize() // 이미지가 카드를 꽉 채우도록
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun ComplexGridWithRowColumnPreview() {
}
