package com.kiy.report.core.api.impl.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject


@Serializable
data class MusinsaProductsResponse(
    @SerialName("data")
    val products: List<MusinsaDataResponse>
)

@Serializable
data class MusinsaDataResponse(
    @SerialName("contents")
    val contents: Contents,
    @SerialName("footer")
    val footer: Footer? = null,
    @SerialName("header")
    val header: Header? = null
)

@Serializable
data class Contents(
    @SerialName("banners")
    val banners: List<Banner>? = null,
    @SerialName("goods")
    val goods: List<Good>? = null,
    @SerialName("styles")
    val styles: List<Style>? = null,
    @SerialName("type")
    val type: String
)

@Serializable
data class Footer(
    @SerialName("iconURL")
    val iconURL: String?= null,
    @SerialName("title")
    val title: String?= null,
    @SerialName("type")
    val type: String?= null
)

@Serializable
data class Header(
    @SerialName("iconURL")
    val iconURL: String? = null,
    @SerialName("linkURL")
    val linkURL: String?= null,
    @SerialName("title")
    val title: String?= null
)

@Serializable
data class Banner(
    @SerialName("description")
    val description: String,
    @SerialName("keyword")
    val keyword: String,
    @SerialName("linkURL")
    val linkURL: String,
    @SerialName("thumbnailURL")
    val thumbnailURL: String,
    @SerialName("title")
    val title: String
)

@Serializable
data class Good(
    @SerialName("brandName")
    val brandName: String,
    @SerialName("hasCoupon")
    val hasCoupon: Boolean,
    @SerialName("linkURL")
    val linkURL: String,
    @SerialName("price")
    val price: Int,
    @SerialName("saleRate")
    val saleRate: Int,
    @SerialName("thumbnailURL")
    val thumbnailURL: String
)

@Serializable
data class Style(
    @SerialName("linkURL")
    val linkURL: String,
    @SerialName("thumbnailURL")
    val thumbnailURL: String
)
