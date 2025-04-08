package com.kiy.report.core.model

import com.kiy.report.core.model.constants.ContentType
import com.kiy.report.core.model.constants.FooterType


sealed interface MusinsaUiData {
    data class BannerTypeData(
        val title: String, // NEW IN FASHION FOR WOMEN
        val description: String, // 노이아고, 리올그, 엔오르 외 최대 40% 할인
        val keyword: String = "", // 무신사 추천
        val linkURL: String = "", // https://www.musinsa.com/app/plan/views/22293
        val thumbnailURL: String // https://image.msscdn.net/images/event_banner/2022062215240900000026699.jpg
    ) : MusinsaUiData

    data class StyleTypeData(
        val linkUrl: String,
        val thumbnailUrl: String,
    ) : MusinsaUiData

    data class ScrollGoodsData(
        val brandName: String, // 아스트랄 프로젝션
        val hasCoupon: Boolean, // true
        val linkURL: String, // https://www.musinsa.com/app/goods/2281818
        val price: Int, // 39900
        val saleRate: Int, // 50
        val thumbnailURL: String // https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg
    ) : MusinsaUiData {
        fun getPriceText(): String {
            return "%,d원".format(price)
        }
    }

    data class GridGoodsData(
        val brandName: String, // 아스트랄 프로젝션
        val hasCoupon: Boolean, // true
        val linkURL: String, // https://www.musinsa.com/app/goods/2281818
        val price: Int, // 39900
        val saleRate: Int, // 50
        val thumbnailURL: String // https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg
    ) : MusinsaUiData {
        fun getPriceText(): String {
            return "%,d원".format(price)
        }
    }
}

data class HeaderData(
    val title: String?,
    val iconURL: String? = null,
    val linkURL: String? = null,
)

data class FooterData(
    val type: FooterType? = null,
    val title: String
)

data class MusinsaUiComponent(
    val type: ContentType,
    val maxVisibleItemCount: Int = 6,
    val headerData: HeaderData? = null,
    val footerData: FooterData? = null,
    val list : List<MusinsaUiData> = emptyList(),
)