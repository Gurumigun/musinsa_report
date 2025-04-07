package com.kiy.report.core.designsystem.theme.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable


@Composable
fun Headers(
    title: String,
    linkUrl: String? = null,
    iconUrl: String? = null,
    onClick: () -> Unit
) {
}


@Composable
fun Headers(
    title: String,
    linkContent: @Composable () -> Unit = {},
    iconContent: @Composable () -> Unit = {},
) {
    Row {
        MusinsaText.
    }
}