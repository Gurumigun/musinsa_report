package com.kiy.report.feature.home

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.kiy.report.core.domain.usecase.GetMusinsaProductItemsUseCase
import com.kiy.report.core.domain.usecase.ShuffleProductItemsUseCase
import com.kiy.report.feature.home.state.MainEvent
import com.kiy.report.feature.home.state.MainUiState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 7.
 */
class MainViewModel @AssistedInject constructor(
    private val getMusinsaProductItemsUseCase: GetMusinsaProductItemsUseCase,
    @Assisted initialState: MainUiState,
) : MavericksViewModel<MainUiState>(initialState) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MainViewModel, MainUiState>

    companion object :
        MavericksViewModelFactory<MainViewModel, MainUiState> by hiltMavericksViewModelFactory()

    init {
        viewModelScope.launch {
            updateLoading(true)
            getMusinsaProductItemsUseCase()
                .onSuccess {
                    setState { copy(isLoading = false, data = it) }
                }
        }
    }

    private fun updateLoading(isLoading: Boolean) {
        setState { copy(isLoading = isLoading) }
    }

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.Refresh -> {
                refresh(event.position)
            }

            is MainEvent.UpdateMoreLoad -> {
                updateMoreLoad(event.position)
            }
        }
    }

    private fun refresh(position: Int) {
        viewModelScope.launch {
            val newList = awaitState().data.getOrNull(position)?.let {
                it.copy(
                    list = it.list.shuffled()
                )
            } ?: return@launch
            setState { copy(isLoading = false, data = data.mapIndexed { index, musinsaUiComponent ->
                if (position == index) newList else musinsaUiComponent
            }) }
        }
    }

    private fun updateMoreLoad(position: Int) {
        setState {
            copy(
                data = data.mapIndexed { index, musinsaUiComponent ->
                    if (position == index) {
                        val nextMaxVisibleItemCount = musinsaUiComponent.maxVisibleItemCount + 3
                        val listSize = musinsaUiComponent.list.size
                        musinsaUiComponent.copy(
                            maxVisibleItemCount = nextMaxVisibleItemCount,
                            footerData = if (nextMaxVisibleItemCount > listSize) {
                                null
                            } else {
                                musinsaUiComponent.footerData
                            }
                        )
                    } else {
                        musinsaUiComponent
                    }
                }
            )
        }
    }
}
