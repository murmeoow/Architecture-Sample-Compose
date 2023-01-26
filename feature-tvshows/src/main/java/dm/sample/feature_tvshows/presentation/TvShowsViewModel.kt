package dm.sample.feature_tvshows.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dm.sample.core.navigation.TvShowsDestination
import dm.sample.core.navigation.NavigationManager
import dm.sample.feature_tvshows.domain.usecase.GetAllTvShowsUseCase
import dm.sample.feature_tvshows.presentation.mapper.toUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getAllTvShowsUseCase: GetAllTvShowsUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(TvShowUiState())
    var uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
        _uiState.update { it.copy(isLoading = true) }
            getAllTvShowsUseCase.invoke()
                .onSuccess { tvShows ->
                    _uiState.update { it.copy(
                        isLoading = false,
                        tvShows = tvShows.map { it.toUi() }
                    ) }
                }
                .onFailure {
                    _uiState.update { it.copy(isError = true, isLoading = false) }
                }
        }
    }

    fun onEvent(event: TvShowsUiEvent) {
        when (event) {
            is TvShowsUiEvent.GoToDetails -> goToDetails(event.showId)
        }
    }

    private fun goToDetails(id: Long) {
        navigationManager.navigate(TvShowsDestination.TvShowDetails.tvShowDetails(id))
    }

}