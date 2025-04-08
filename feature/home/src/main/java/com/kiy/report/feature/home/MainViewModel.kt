package com.kiy.report.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiy.report.core.domain.usecase.GetMusinsaProductItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * Create : Kwon IkYoung
 * Date : 2025. 4. 7.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMusinsaProductItems: GetMusinsaProductItems,
) : ViewModel() {

    init {
        viewModelScope.launch {
            getMusinsaProductItems()
                .onSuccess {
                    // Handle success
                    it
                }
        }
    }
}
