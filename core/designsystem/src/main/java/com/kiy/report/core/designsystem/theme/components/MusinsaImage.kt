package com.kiy.report.core.designsystem.theme.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale

object MusinsaImage {
    @Composable
    fun Image(
        imageResource: ImageResource,
        modifier: Modifier = Modifier,
        contentDescription: String? = null,
        contentScale: ContentScale = ContentScale.Fit,
        alpha: Float = 1f,
        colorFilter: ColorFilter? = null
    ) {
        val painter = imageResource()
        painter?.let {
            androidx.compose.foundation.Image(
                painter = it,
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
                alpha = alpha,
                colorFilter = colorFilter
            )
        }
    }
}
