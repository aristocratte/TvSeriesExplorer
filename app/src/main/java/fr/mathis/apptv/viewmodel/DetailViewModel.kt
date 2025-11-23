package fr.mathis.apptv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mathis.apptv.data.model.TvShowDetail
import fr.mathis.apptv.data.repository.TvShowRepository
import fr.mathis.apptv.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TvShowRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<TvShowDetail>>(UiState.Loading)
    val uiState: StateFlow<UiState<TvShowDetail>> = _uiState.asStateFlow()

    private var currentShowId: Int = 0

    fun loadShowDetails(showId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            currentShowId = showId

            repository.getShowDetails(showId)
                .onSuccess { detail ->
                    _uiState.value = UiState.Success(detail)
                }
                .onFailure { error ->
                    _uiState.value = UiState.Error(
                        error.message ?: "Une erreur s'est produite"
                    )
                }
        }
    }

    fun retry() {
        if (currentShowId != 0) {
            loadShowDetails(currentShowId)
        }
    }
}

