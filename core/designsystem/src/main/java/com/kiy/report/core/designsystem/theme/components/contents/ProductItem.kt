package com.kiy.report.core.designsystem.theme.components.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiy.report.core.designsystem.theme.Typography
import com.kiy.report.core.designsystem.theme.components.MusinsaImage
import com.kiy.report.core.designsystem.theme.components.MusinsaText
import com.kiy.report.core.designsystem.theme.components.TextResource


@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    brandName: String,
    imageUrl: String,
    price: String,
    saleRate: Int = 0,
    hasCoupon: Boolean = false,
) {
    Column(
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.BottomStart
        ) {
            MusinsaImage.NetworkImage(
                modifier = Modifier.fillMaxWidth().height(140.dp),
                imageUrl = imageUrl,
                contentScale = ContentScale.Crop,
            )

            if (hasCoupon) {
                MusinsaText.BodySmallText(
                    modifier = Modifier
                        .background(Color.Blue)
                        .padding(4.dp),
                    text = TextResource("쿠폰"),
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        MusinsaText.BodySmallText(
            text = TextResource(brandName),
            style = Typography.bodySmall.copy(
                fontWeight = FontWeight.Bold,
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MusinsaText.BodyLargeText(
                text = TextResource("${saleRate}%"),
                color = Color.Red,
                style = Typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
            MusinsaText.BodyMediumText(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F),
                text = TextResource(price),
            )
        }
    }
}


@Preview
@Composable
private fun previewProductItem() {
    ProductItem(
        modifier = Modifier.background(Color.White),
        brandName = "브랜드",
        imageUrl = "https://image.musinsa.com/mfile_s01/2023/09/12/1/202309121000001000001_1.jpg",
        price = "123,000",
        saleRate = 10,
        hasCoupon = true,
    )

}