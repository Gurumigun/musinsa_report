package com.kiy.report.core.api.impl

import com.kiy.report.core.api.impl.api.MusinsaApi
import com.kiy.report.core.api.impl.mapper.toDomain
import com.kiy.report.core.model.MusinsaUiComponent
import com.kiy.report.data.api.MusinsaRepository
import javax.inject.Inject

internal class MusinsaRepositoryImpl @Inject constructor(
    private val musinsaApi: MusinsaApi,
) : MusinsaRepository {
    override suspend fun getMusinsaProducts(): Result<List<MusinsaUiComponent>> {
        return runCatching {
            musinsaApi.getProductList().body()?.toDomain() ?: throw NullPointerException()
        }
    }

}
