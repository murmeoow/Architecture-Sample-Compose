package dm.sample.feature_tvshows.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dm.sample.core.navigation.NavigationManager
import dm.sample.core.navigation.TvShowsDestination
import dm.sample.feature_tvshows.domain.usecase.GetTvShowUseCase
import dm.sample.feature_tvshows.presentation.mapper.toUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowDetailsViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val getTvShowUseCase: GetTvShowUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _uiState = MutableStateFlow(TvShowDetailsUiState())
    var uiState = _uiState.asStateFlow()

    val showId = savedStateHandle.get<String>(TvShowsDestination.TvShowDetails.DETAILS_KEY) ?: "1"

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            getTvShowUseCase.invoke(showId.replace("{", "").replace("}", "").toLong())
                .onSuccess {tvShow ->
                    _uiState.update { it.copy(isLoading = false, tvShowUi = tvShow.toUi()) }
                }
                .onFailure {
                    _uiState.update { it.copy(isLoading = false, isError = true) }
                }
        }
    }

    fun navigateBack() {
        navigationManager.popBackStack()
    }

}