package com.kiy.report.core.designsystem.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Headers(
    title: String,
    linkUrl: String? = null,
    iconUrl: String? = null,
    onLinkClick: (String) -> Unit = {},
) {
    Headers(
        title = title,
        linkContent = {
            linkUrl?.let {
                MusinsaText.TitleMediumText(
                    text = TextResource(it),
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            onLinkClick(it)
                        },
                    color = Color.DarkGray
                )
            }
        },
        iconContent = {
            iconUrl?.let {
                MusinsaImage.NetworkImage(
                    modifier = Modifier.size(24.dp),
                    imageUrl = it
                )
            }
        }
    )
}


@Composable
fun Headers(
    title: String,
    linkContent: @Composable () -> Unit = {},
    iconContent: @Composable () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MusinsaText.TitleLargeText(
            text = TextResource(title)
        )
        iconContent()
        Spacer(modifier = Modifier.weight(1f))
        linkContent()
    }
}