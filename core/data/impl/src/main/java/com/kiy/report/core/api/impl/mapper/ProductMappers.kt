package com.kiy.report.core.api.impl.mapper

import com.kiy.report.core.api.impl.api.model.MusinsaProductsResponse
import com.kiy.report.core.model.FooterData
import com.kiy.report.core.model.HeaderData
import com.kiy.report.core.model.MusinsaUiComponent
import com.kiy.report.core.model.MusinsaUiData
import com.kiy.report.core.model.constants.ContentType
import com.kiy.report.core.model.constants.FooterType

fun MusinsaProductsResponse.toDomain(): List<MusinsaUiComponent> {
    val resultList = this.products.map {
        val type = ContentType.findByType(it.contents.type)
        val contentList = when (type) {
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

        if (type == null || contentList == null) {
            return@map null
        }

        return@map MusinsaUiComponent(
            type = type,
            headerData = it.header?.let { header ->
                if (header.title == null) {
                    return@map null
                }

                HeaderData(
                    title = header.title,
                    iconURL = header.iconURL,
                    linkURL = header.linkURL
                )
            },
            footerData = it.footer?.let { footer ->
                if (footer.title == null) {
                    return@map null
                }

                FooterData(
                    type = FooterType.findByType(footer.type),
                    title = footer.title
                )
            },
            list = contentList ?: emptyList()
        )
    }.filterNotNull()

    return resultList
}
