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
class SearchViewModel @Inject constructor(
    private val repository: TvShowRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<TvShow>>>(UiState.Success(emptyList()))
    val uiState: StateFlow<UiState<List<TvShow>>> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchShows(query: String) {
        if (query.isBlank()) {
            _uiState.value = UiState.Success(emptyList())
            return
        }

        viewModelScope.launch {
            _uiState.value = UiState.Loading

            repository.searchShows(query)
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
        if (_searchQuery.value.isNotBlank()) {
            searchShows(_searchQuery.value)
        }
    }
}

