package dm.sample.feature_tvshows.presentation

import dm.sample.feature_tvshows.presentation.model.TvShowUi

data class TvShowDetailsUiState(
    val tvShowUi: TvShowUi = TvShowUi(0,"", "","","","","",0.0),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)