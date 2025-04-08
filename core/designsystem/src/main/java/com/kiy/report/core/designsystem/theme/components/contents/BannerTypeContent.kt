package com.kiy.report.core.designsystem.theme.components.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiy.report.core.designsystem.theme.MusinsaReportTheme
import com.kiy.report.core.designsystem.theme.components.MusinsaImage
import com.kiy.report.core.designsystem.theme.components.MusinsaText
import com.kiy.report.core.designsystem.theme.components.TextResource
import com.kiy.report.core.model.MusinsaUiData
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.math.absoluteValue

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 8.
 */
@Composable
fun ImageBannerPagerComponent(
    modifier: Modifier = Modifier.aspectRatio(1F),
    items: List<MusinsaUiData.BannerTypeData>,
    enableAutoScroll: Boolean = true,
    autoScrollDurationMillis: Long = 3000L,
    enableParallax: Boolean = true,
    parallaxFactor: Float = 0.5f,
    indicatorBackgroundColor: Color = Color.Black.copy(alpha = 0.5f),
    indicatorTextColor: Color = Color.White,
    onBannerClick: (MusinsaUiData.BannerTypeData) -> Unit = {}
) {
    if (items.isEmpty()) {
        return
    }

    val pagerState = rememberPagerState(pageCount = { items.size })

    if (enableAutoScroll && items.size > 1) {
        LaunchedEffect(pagerState.currentPage) {
            while (true) {
                delay(autoScrollDurationMillis)
                withContext(NonCancellable) {
                    val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }
    }

    Box(modifier = modifier) {
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) { pageIndex ->
            val item = items[pageIndex]

            val pageOffset = calculateCurrentOffsetForPage(pagerState, pageIndex).absoluteValue

            BannerPageItem(
                title = item.title,
                description = item.description,
                thumbnailImage = item.thumbnailURL,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        onBannerClick(item)
                    }
                    .then(
                        if (enableParallax) {
                            Modifier.graphicsLayer {
                                translationX = size.width * (pageOffset * parallaxFactor)
                                // alpha = 1f - pageOffset.coerceIn(0f, 1f)
                                // scaleX = 1f - (pageOffset.coerceIn(0f, 1f) * 0.2f)
                                // scaleY = 1f - (pageOffset.coerceIn(0f, 1f) * 0.2f)
                            }
                        } else Modifier
                    )

            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(indicatorBackgroundColor)
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            MusinsaText.BodyMediumText(
                text = TextResource("${pagerState.currentPage + 1} / ${pagerState.pageCount}"),
                color = indicatorTextColor,
            )
        }
    }
}

@Composable
fun BannerPageItem(
    modifier: Modifier = Modifier,
    title: String = "",
    description: String = "",
    thumbnailImage: String = ""
) {
    Box(modifier = modifier) {
        MusinsaImage.NetworkImage(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1F),
            imageUrl = thumbnailImage,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {

            MusinsaText.BodyMediumText(
                modifier = Modifier,
                text = TextResource(title),
                color = Color.White,
            )

            MusinsaText.BodySmallText(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                text = TextResource(description),
                color = Color.White,
            )
        }
    }
}

fun calculateCurrentOffsetForPage(pagerState: PagerState, page: Int): Float {
    return (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
}


@Preview
@Composable
private fun previewBannerTypeContent() {
    MusinsaReportTheme {
        ImageBannerPagerComponent(
            items = listOf(
                MusinsaUiData.BannerTypeData(
                    title = "Title 1",
                    description = "Description 1",
                    thumbnailURL = "https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg",
                    keyword = "",
                    linkURL = ""
                ),
                MusinsaUiData.BannerTypeData(
                    title = "Title 2",
                    description = "Description 2",
                    thumbnailURL = "https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg",
                    keyword = "",
                    linkURL = ""
                ),
                MusinsaUiData.BannerTypeData(
                    title = "Title 3",
                    description = "Description 3",
                    thumbnailURL = "https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg",
                    keyword = "",
                    linkURL = ""
                )
            )
        )
    }
}
