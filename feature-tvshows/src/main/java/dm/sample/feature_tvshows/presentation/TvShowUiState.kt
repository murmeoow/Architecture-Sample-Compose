package dm.sample.feature_tvshows.presentation

import dm.sample.feature_tvshows.presentation.model.TvShowUi

data class TvShowUiState(
    val isLoading: Boolean = false,
    val tvShows: List<TvShowUi> = emptyList(),
    val isError: Boolean = false
)