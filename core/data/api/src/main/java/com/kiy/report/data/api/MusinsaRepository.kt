package com.kiy.report.data.api

import com.kiy.report.core.model.MusinsaUiComponent


interface MusinsaRepository {
    suspend fun getMusinsaProducts(): Result<List<MusinsaUiComponent>>
}