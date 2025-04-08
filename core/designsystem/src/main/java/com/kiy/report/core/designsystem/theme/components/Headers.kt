package com.kiy.report.core.designsystem.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension


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
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp)
                        .clickable {
                            onLinkClick(it)
                        },
                    text = TextResource(it),
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
    linkContent: (@Composable () -> Unit)? = null,
    iconContent: (@Composable () -> Unit)? = null,
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        val (titleRef, iconRef, linkRef) = createRefs()

        // 체인 생성
        createHorizontalChain(
            titleRef,
            iconRef,
            linkRef,
            chainStyle = ChainStyle.SpreadInside
        )

        MusinsaText.TitleLargeText(
            modifier = Modifier.constrainAs(titleRef) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            },
            text = TextResource(title),
            maxLines = 2,
        )

        Box(
            modifier = Modifier
                .padding(start = 4.dp)
                .constrainAs(iconRef) {
                    top.linkTo(titleRef.top)
                    bottom.linkTo(titleRef.bottom)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
        ) {
            if (iconContent != null) {
                iconContent()
            }
        }

        Box(
            modifier = Modifier.constrainAs(linkRef) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        ) {
            if (linkContent != null) {
                linkContent()
            } else {
                Box(modifier = Modifier.size(1.dp))
            }
        }

    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun previewHeaders() {
    Column {
        Headers(
            title = "shdjfgaskjhdfgaskf87234t928`173t4weflkvcsxb mxcnbvwpfdu2ewrp97yr",
        )
        Headers(
            title = "shdjfgaskjhdfgaskf87234t928`173t4weflkvcsxb mxcnbvwpfdu2ewrp97yr",
            iconUrl = "Link",
        )
        Headers(
            title = "shdjfgaskjhdfgaskf87234t928`173t4weflkvcsxb mxcnbvwpfdu2ewrp97yr",
            linkUrl = "Link",
        )
        Headers(
            title = "TitleTitleTitleTitleTitleTitleTi",
            linkContent = {
                MusinsaText.TitleMediumText(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp)
                        .clickable { },
                    text = TextResource("Link"),
                    color = Color.DarkGray
                )
            },
            iconContent = {
                MusinsaImage.Image(
                    imageResource = ImageResource(Icons.Default.Refresh),
                    modifier = Modifier.size(24.dp),
                )
            }
        )
        Headers(
            title = "TitleTitleTitleTitleTitleTitleTiasdfasdfTitleTitleTitleTitleTitleTitleTiasdfasdf",
            linkContent = {
                MusinsaText.TitleMediumText(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp)
                        .clickable { },
                    text = TextResource("Link"),
                    color = Color.DarkGray
                )
            },
            iconContent = {
                MusinsaImage.Image(
                    imageResource = ImageResource(Icons.Default.Refresh),
                    modifier = Modifier.size(24.dp),
                )
            }
        )
    }
}