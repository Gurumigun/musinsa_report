package com.kiy.report.core.designsystem.theme.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.kiy.report.core.designsystem.theme.TextPrimary
import com.kiy.report.core.designsystem.theme.Typography

object MusinsaText {
    @Composable
    fun TitleLargeText(
        text: TextResource,
        modifier: Modifier = Modifier,
        color: Color = TextPrimary,
        style: TextStyle = Typography.titleLarge,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1,
    ) {
        Text(
            text(),
            modifier = modifier,
            style = style,
            color = color,
            maxLines = maxLines,
            minLines = minLines
        )
    }

    @Composable
    fun TitleMediumText(
        text: TextResource,
        modifier: Modifier = Modifier,
        color: Color = TextPrimary,
        style: TextStyle = Typography.titleMedium,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1,
    ) {
        Text(
            text(),
            modifier = modifier,
            style = style,
            color = color,
            maxLines = maxLines,
            minLines = minLines
        )
    }

    @Composable
    fun BodySmallText(
        text: TextResource,
        modifier: Modifier = Modifier,
        color: Color = TextPrimary,
        style: TextStyle = Typography.bodySmall,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1,
    ) {
        Text(
            text(),
            modifier = modifier,
            color = color,
            style = style,
            maxLines = maxLines,
            minLines = minLines
        )
    }

    @Composable
    fun BodyMediumText(
        text: TextResource,
        modifier: Modifier = Modifier,
        color: Color = TextPrimary,
        style: TextStyle = Typography.bodyMedium,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1,
    ) {
        Text(
            text(),
            modifier = modifier,
            color = color,
            style = style,
            maxLines = maxLines,
            minLines = minLines
        )
    }
    @Composable
    fun BodyLargeText(
        text: TextResource,
        modifier: Modifier = Modifier,
        color: Color = TextPrimary,
        style: TextStyle = Typography.bodyLarge,
        maxLines: Int = Int.MAX_VALUE,
        minLines: Int = 1,
    ) {
        Text(
            text(),
            modifier = modifier,
            color = color,
            style = style,
            maxLines = maxLines,
            minLines = minLines
        )
    }
}
