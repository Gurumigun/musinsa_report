package com.kiy.report.core.domain.usecase

import com.kiy.report.core.model.MusinsaUiComponent
import com.kiy.report.data.api.MusinsaRepository
import javax.inject.Inject

class GetMusinsaProductItems @Inject constructor(
    private val repository: MusinsaRepository
){
    suspend operator fun invoke(): Result<List<MusinsaUiComponent>> {
        return repository.getMusinsaProducts()
    }
}