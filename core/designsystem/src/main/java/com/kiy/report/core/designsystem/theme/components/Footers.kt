package com.kiy.report.core.designsystem.theme.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FooterCard(
    modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .border(
                    border = BorderStroke(
                        width = 1.dp, color = Color(0xFFE0E0E0)
                    ), shape = RoundedCornerShape(40.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            content()
        }
    }
}

@Composable
fun RefreshFooter(
    modifier: Modifier = Modifier, onRefreshClick: () -> Unit
) {
    FooterCard(modifier = modifier.clickable { onRefreshClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(36.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            MusinsaImage.Image(
                imageResource = ImageResource(Icons.Default.Refresh)
            )
            Spacer(modifier = Modifier.width(4.dp))
            MusinsaText.BodySmallText(
                text = TextResource("새로고침"),

                )
        }
    }
}

@Composable
fun MoreFooter(
    modifier: Modifier = Modifier, onMoreClick: () -> Unit
) {
    FooterCard(modifier = modifier
        .clickable { onMoreClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(36.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            MusinsaText.BodySmallText(
                text = TextResource("더보기"),

                )
        }
    }
}

@Preview
@Composable
private fun previewFooters() {
    Column {
        RefreshFooter(onRefreshClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        MoreFooter(onMoreClick = {})
    }
}
