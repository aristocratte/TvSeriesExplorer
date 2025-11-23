package fr.mathis.apptv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mathis.apptv.data.model.TvShow
import fr.mathis.apptv.data.repository.TvShowRepository
import fr.mathis.apptv.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TvShowRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<TvShow>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<TvShow>>> = _uiState.asStateFlow()

    private var currentPage = 1

    init {
        loadMostPopularShows()
    }

    fun loadMostPopularShows(page: Int = 1) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            currentPage = page

            repository.getMostPopularShows(page)
                .onSuccess { shows ->
                    _uiState.value = UiState.Success(shows)
                }
                .onFailure { error ->
                    _uiState.value = UiState.Error(
                        error.message ?: "Une erreur s'est produite"
                    )
                }
        }
    }

    fun retry() {
        loadMostPopularShows(currentPage)
    }
}

