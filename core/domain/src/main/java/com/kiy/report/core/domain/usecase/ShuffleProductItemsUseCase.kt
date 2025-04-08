package com.kiy.report.core.domain.usecase

import com.kiy.report.core.model.MusinsaUiComponent
import com.kiy.report.data.api.MusinsaRepository
import javax.inject.Inject

class ShuffleProductItemsUseCase @Inject constructor(
    private val repository: MusinsaRepository
) {
    suspend operator fun invoke(position: Int): Result<List<MusinsaUiComponent>> =
        runCatching {
            val list = repository.getMusinsaProducts().getOrThrow()
            return@runCatching list.mapIndexed { index, musinsaUiComponent ->
                if (index == position) {
                    musinsaUiComponent.copy(
                        list = musinsaUiComponent.list.shuffled()
                    )
                } else {
                    musinsaUiComponent
                }
            }
        }
}