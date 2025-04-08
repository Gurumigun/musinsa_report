package com.kiy.report.feature.home.state

import com.airbnb.mvrx.MavericksState
import com.kiy.report.core.model.MusinsaUiComponent

data class MainUiState(
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val data: List<MusinsaUiComponent> = emptyList()
): MavericksState


sealed class MainEvent {
    data class Refresh(val position: Int) : MainEvent()
    data class UpdateMoreLoad(val position: Int) : MainEvent()
}

sealed class MainSideEffect {
    data class ShowToast(val message: String) : MainSideEffect()
}
