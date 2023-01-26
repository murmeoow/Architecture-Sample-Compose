package dm.sample.feature_tvshows.presentation

sealed class TvShowsUiEvent {
    data class GoToDetails(val showId: Long) : TvShowsUiEvent()
}