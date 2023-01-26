package dm.sample.feature_tvshows.presentation

import android.util.Log
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
                    Log.d("STATE1", "shows = ${tvShows} ")
                    _uiState.update { it.copy(
                        isLoading = false,
                        tvShows = tvShows.map { it.toUi() }
                    ) }
                }
                .onFailure {
                    Log.d("bug", "error = ${it} ")
                    _uiState.update { it.copy(isError = true, isLoading = false) }
                }
        }
    }

    fun navigateToDetails(id: Long) {
        navigationManager.navigate(TvShowsDestination.TvShowDetails.tvShowDetails(id))
    }

}