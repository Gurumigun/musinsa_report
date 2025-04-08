package com.kiy.report.core.api.impl.mapper

import com.kiy.report.core.api.impl.api.model.MusinsaProductsResponse
import com.kiy.report.core.model.MusinsaProducts
import com.kiy.report.core.model.MusinsaUiData
import com.kiy.report.core.model.constants.ContentType

fun MusinsaProductsResponse.toDomain(): MusinsaProducts {
    val list = this.products.map {
        val type = ContentType.findByType(it.contents.type)
        return@map when (type) {
            ContentType.BANNER -> {
                it.contents.banners?.map { banner ->
                    MusinsaUiData.BannerTypeData(
                        title = banner.title,
                        description = banner.description,
                        keyword = banner.keyword,
                        linkURL = banner.linkURL,
                        thumbnailURL = banner.thumbnailURL,
                    )
                }
            }

            ContentType.GRID -> it.contents.goods?.map { goods ->
                MusinsaUiData.GridGoodsData(
                    brandName = goods.brandName,
                    hasCoupon = goods.hasCoupon,
                    linkURL = goods.linkURL,
                    price = goods.price,
                    saleRate = goods.saleRate,
                    thumbnailURL = goods.thumbnailURL
                )
            }

            ContentType.SCROLL -> it.contents.goods?.map { goods ->
                MusinsaUiData.ScrollGoodsData(
                    brandName = goods.brandName,
                    hasCoupon = goods.hasCoupon,
                    linkURL = goods.linkURL,
                    price = goods.price,
                    saleRate = goods.saleRate,
                    thumbnailURL = goods.thumbnailURL
                )
            }

            ContentType.STYLE -> it.contents.styles?.map { style ->
                MusinsaUiData.StyleTypeData(
                    linkUrl = style.linkURL,
                    thumbnailUrl = style.thumbnailURL,
                )
            }

            null -> null
        }
    }.filterNotNull()

    return MusinsaProducts(
        type = "",
        goods = list
    )
}
