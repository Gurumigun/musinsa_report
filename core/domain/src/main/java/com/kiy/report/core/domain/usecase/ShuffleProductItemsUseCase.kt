package com.kiy.report.core.domain.usecase

import com.kiy.report.core.model.MusinsaUiComponent
import com.kiy.report.data.api.MusinsaRepository
import javax.inject.Inject

class ShuffleProductItemsUseCase @Inject constructor(
    private val repository: MusinsaRepository
) {
    suspend operator fun invoke(item : MusinsaUiComponent): Result<MusinsaUiComponent> =
        runCatching {
            return@runCatching item.copy(
                list = item.list.shuffled()
            )
        }
}
