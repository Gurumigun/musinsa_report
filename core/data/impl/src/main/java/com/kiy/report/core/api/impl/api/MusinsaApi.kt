package com.kiy.report.core.api.impl.api

import com.kiy.report.core.api.impl.api.model.MusinsaProductsResponse
import retrofit2.Response
import retrofit2.http.GET


/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 7.
 */
internal interface MusinsaApi {
    @GET("/interview/list.json")
    suspend fun getProductList(): Response<MusinsaProductsResponse>
}
