package com.kiy.report.core.designsystem.theme.components.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiy.report.core.designsystem.theme.components.Headers
import com.kiy.report.core.designsystem.theme.components.MoreFooter
import com.kiy.report.core.designsystem.theme.components.RefreshFooter
import com.kiy.report.core.designsystem.theme.components.contents.GridTypeComponent
import com.kiy.report.core.designsystem.theme.components.contents.ImageBannerPagerComponent
import com.kiy.report.core.designsystem.theme.components.contents.ScrollTypeComponent
import com.kiy.report.core.designsystem.theme.components.contents.StyleTypeComponent
import com.kiy.report.core.model.MusinsaUiData
import com.kiy.report.core.model.constants.FooterType

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 8.
 */

@Composable
fun ScrollTypeContents(
    modifier: Modifier = Modifier.wrapContentHeight(),
    items: List<MusinsaUiData.ScrollGoodsData> = emptyList(),
    title: String? = null,
    linkUrl: String? = null,
    iconUrl: String? = null,
    footerType: FooterType? = null,
    footerClick: () -> Unit = {},
    onItemClick: (MusinsaUiData.ScrollGoodsData) -> Unit = {}
) {
    ListContainer(
        modifier = modifier,
        title = title,
        linkUrl = linkUrl,
        iconUrl = iconUrl,
        footerType = footerType,
        footerClick = footerClick
    ) {
        ScrollTypeComponent(
            items = items,
            onItemClick = onItemClick,
        )
    }
}

@Composable
fun GridContents(
    modifier: Modifier = Modifier.wrapContentHeight(),
    items: List<MusinsaUiData.GridGoodsData> = emptyList(),
    maxCount: Int = 6,
    title: String?,
    linkUrl: String? = null,
    iconUrl: String? = null,
    footerType: FooterType? = null,
    footerClick: () -> Unit = {},
    onItemClick: (MusinsaUiData.GridGoodsData) -> Unit = {}
) {
    ListContainer(
        modifier = modifier,
        title = title,
        linkUrl = linkUrl,
        iconUrl = iconUrl,
        footerType = footerType,
        footerClick = footerClick
    ) {
        GridTypeComponent(
            items =  items.take(maxCount),
            onItemClick = onItemClick,
        )
    }
}

@Composable
fun StyleGridContents(
    modifier: Modifier = Modifier.wrapContentHeight(),
    items: List<MusinsaUiData.StyleTypeData> = emptyList(),
    maxVisibleItemCount: Int = 6,
    title: String?,
    linkUrl: String? = null,
    iconUrl: String? = null,
    footerType: FooterType? = null,
    footerClick: () -> Unit = {},
    onItemClick: (MusinsaUiData.StyleTypeData) -> Unit = {}
) {
    ListContainer(
        modifier = modifier,
        title = title,
        linkUrl = linkUrl,
        iconUrl = iconUrl,
        footerType = footerType,
        footerClick = footerClick
    ) {
        StyleTypeComponent(
            styleTypeDataList = items,
            maxVisibleCount = maxVisibleItemCount,
            onItemClick = onItemClick
        )
    }
}


@Composable
fun BannerListContents(
    modifier: Modifier = Modifier.wrapContentHeight(),
    items: List<MusinsaUiData.BannerTypeData> = emptyList(),
    title: String?,
    linkUrl: String? = null,
    iconUrl: String? = null,
    footerType: FooterType? = null,
    footerClick: () -> Unit = {},
    onBannerClick: (MusinsaUiData.BannerTypeData) -> Unit = {}
) {
    ListContainer(
        modifier = modifier,
        title = title,
        linkUrl = linkUrl,
        iconUrl = iconUrl,
        footerType = footerType,
        footerClick = footerClick
    ) {
        ImageBannerPagerComponent(
            items = items,
            onBannerClick = onBannerClick
        )
    }
}


@Composable
fun ListContainer(
    modifier: Modifier = Modifier,
    title: String? = null,
    linkUrl: String? = null,
    iconUrl: String? = null,
    footerType: FooterType? = null,
    footerClick: () -> Unit = {},
    contents: @Composable () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        if (title != null) {
            Headers(
                title = title,
                linkUrl = linkUrl,
                iconUrl = iconUrl
            )
            Spacer(Modifier.height(8.dp))
        }

        contents()

        if (footerType != null) {
            Spacer(Modifier.height(8.dp))
        }

        if (footerType == FooterType.REFRESH) {
            RefreshFooter {
                footerClick()
            }
        } else if (footerType == FooterType.MORE) {
            MoreFooter {
                footerClick()
            }
        }
    }
}

@Preview
@Composable
private fun previewListContainer() {
    Column {
        ListContainer(
            title = "Title",
            linkUrl = "https://example.com",
            iconUrl = "https://example.com/icon.png",
            footerType = FooterType.MORE,
            footerClick = { /* Handle footer click */ },
        ) {

        }
    }
}