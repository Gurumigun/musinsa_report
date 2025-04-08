package com.kiy.report.core.designsystem.theme.components.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    styleTypeDataList: List<MusinsaUiData.StyleTypeData>,
    onItemClick: (MusinsaUiData.StyleTypeData) -> Unit
) {
    CustomComplexGridLayout(
        modifier = modifier,
        spacing = 8.dp,
    ) {
        styleTypeDataList.forEach { product ->
            ImageGridItem(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                product = product,
                onItemClick = onItemClick,
            )
        }

        if (styleTypeDataList.size < 6) {
            repeat(6 - styleTypeDataList.size) {
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .background(Color.LightGray)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun CustomComplexGridLayout(
    modifier: Modifier = Modifier,
    spacing: Dp = 4.dp,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        if (measurables.size < 6) {
            return@Layout layout(constraints.minWidth, constraints.minHeight) {}
        }

        val spacingPx = spacing.roundToPx()
        val totalHorizontalSpacing = spacingPx * 2
        val maxWidth = constraints.maxWidth

        val availableWidth = maxWidth - totalHorizontalSpacing
        val columnWidth = if (availableWidth > 0) availableWidth / 3 else 0

        val item0Constraints = Constraints.fixedWidth(columnWidth * 2 + spacingPx)
        val singleColumnConstraints = Constraints.fixedWidth(columnWidth)

        val placeable0 = measurables[0].measure(item0Constraints)
        val placeable1 = measurables[1].measure(singleColumnConstraints)
        val placeable2 = measurables[2].measure(singleColumnConstraints)
        val placeable3 = measurables[3].measure(singleColumnConstraints)
        val placeable4 = measurables[4].measure(singleColumnConstraints)
        val placeable5 = measurables[5].measure(singleColumnConstraints)

        val firstSectionHeight = max(
            placeable0.height,
            placeable1.height + spacingPx + placeable2.height
        )
        val secondSectionHeight = max(
            placeable3.height,
            max(placeable4.height, placeable5.height)
        )

        val totalHeight = firstSectionHeight + spacingPx + secondSectionHeight
        val finalHeight = totalHeight.coerceIn(constraints.minHeight, constraints.maxHeight)

        layout(width = maxWidth, height = finalHeight) {
            val col0X = 0
            val col1X = columnWidth + spacingPx
            val col2X = columnWidth * 2 + spacingPx * 2

            val topRowY = 0
            val bottomRowY = firstSectionHeight + spacingPx

            placeable0.placeRelative(x = col0X, y = topRowY)
            placeable1.placeRelative(x = col2X, y = topRowY)
            placeable2.placeRelative(x = col2X, y = topRowY + placeable1.height + spacingPx)
            placeable3.placeRelative(x = col0X, y = bottomRowY)
            placeable4.placeRelative(x = col1X, y = bottomRowY)
            placeable5.placeRelative(x = col2X, y = bottomRowY)
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
    CustomComplexGridLayout(
        spacing = 8.dp
    ) {
//        ImageGridItem(
//            product = MusinsaProducts(),
//            onItemClick = { /* Handle item click */ },
//        )
//        ImageGridItem(
//            product = MusinsaProducts(),
//            onItemClick = { /* Handle item click */ },
//        )
//        ImageGridItem(
//            product = MusinsaProducts(),
//            onItemClick = { /* Handle item click */ },
//        )
//        ImageGridItem(
//            product = MusinsaProducts(),
//            onItemClick = { /* Handle item click */ },
//        )
//        ImageGridItem(
//            product = MusinsaProducts(),
//            onItemClick = { /* Handle item click */ },
//        )
//        ImageGridItem(
//            product = MusinsaProducts(),
//            onItemClick = { /* Handle item click */ },
//        )
    }
}
