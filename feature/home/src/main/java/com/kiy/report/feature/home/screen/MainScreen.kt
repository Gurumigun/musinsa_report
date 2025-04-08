package com.kiy.report.feature.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.kiy.report.core.designsystem.theme.components.list.BannerListContents
import com.kiy.report.core.designsystem.theme.components.list.GridContents
import com.kiy.report.core.designsystem.theme.components.list.ScrollTypeContents
import com.kiy.report.core.designsystem.theme.components.list.StyleGridContents
import com.kiy.report.core.model.MusinsaUiData
import com.kiy.report.core.model.constants.ContentType
import com.kiy.report.core.model.constants.FooterType
import com.kiy.report.feature.home.MainViewModel
import com.kiy.report.feature.home.state.MainEvent

@Composable
fun MainScreen() {
    val viewModel: MainViewModel = mavericksViewModel()
    val state by viewModel.collectAsState()

    val footerClick: (Int, FooterType?)-> Unit = { index, footerType ->
        when (footerType) {
            FooterType.MORE -> {
                viewModel.onEvent(
                    MainEvent.UpdateMoreLoad(index)
                )
            }

            FooterType.REFRESH -> {
                viewModel.onEvent(
                    MainEvent.Refresh(index)
                )
            }
            else -> {
                // do nothing
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState(), enabled = true)
        ) {
            state.data.forEachIndexed { index, item ->
                val type = item.type
                val header = item.headerData
                val footer = item.footerData
                val list = item.list

                when (type) {
                    ContentType.BANNER -> {
                        BannerListContents(
                            items = list.filterIsInstance<MusinsaUiData.BannerTypeData>(),
                            title = header?.title,
                            iconUrl = header?.iconURL,
                            linkUrl = header?.linkURL,
                            footerType = footer?.type,
                            footerClick = {
                                val footerType = footer?.type
                                footerClick(index, footerType)
                            }
                        )
                    }

                    ContentType.GRID -> {
                        GridContents(
                            items = list.filterIsInstance<MusinsaUiData.GridGoodsData>(),
                            title = header?.title,
                            iconUrl = header?.iconURL,
                            linkUrl = header?.linkURL,
                            footerType = footer?.type,
                            maxCount = item.maxVisibleItemCount,
                            footerClick = {
                                val footerType = footer?.type
                                footerClick(index, footerType)
                            }
                        )
                    }

                    ContentType.SCROLL -> {
                        ScrollTypeContents(
                            items = list.filterIsInstance<MusinsaUiData.ScrollGoodsData>(),
                            title = header?.title,
                            iconUrl = header?.iconURL,
                            linkUrl = "전체",
                            footerType = footer?.type,
                            footerClick = {
                                val footerType = footer?.type
                                footerClick(index, footerType)
                            }
                        )
                    }

                    ContentType.STYLE -> {
                        StyleGridContents(
                            items = list.filterIsInstance<MusinsaUiData.StyleTypeData>(),
                            title = header?.title,
                            iconUrl = header?.iconURL,
                            linkUrl = header?.linkURL,
                            footerType = footer?.type,
                            maxVisibleItemCount = item.maxVisibleItemCount,
                            footerClick = {
                                val footerType = footer?.type
                                footerClick(index, footerType)
                            }
                        )
                    }
                }
            }
        }

        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}
