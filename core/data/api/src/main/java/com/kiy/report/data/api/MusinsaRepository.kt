package com.kiy.report.data.api

import com.kiy.report.core.model.MusinsaProducts

interface MusinsaRepository {
    suspend fun getMusinsaProducts(): Result<MusinsaProducts>
}