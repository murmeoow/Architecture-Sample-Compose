package dm.sample.feature_tvshows.presentation.composables.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import dm.sample.feature_tvshows.presentation.TvShowDetailsUiEvent
import dm.sample.feature_tvshows.presentation.TvShowDetailsViewModel
import dm.sample.feature_tvshows.presentation.composables.TvShowsLoadingContent

@Composable
fun TvShowDetailsScreen(
    viewModel: TvShowDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    when {
        state.isLoading -> TvShowsLoadingContent()
        state.isError -> {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Red))
        }
        else -> TvShowDetailsContent(
            tvShow = state.tvShowUi,
            onBackClick = { viewModel.onEvent(TvShowDetailsUiEvent.GoBack) }
        )
    }
}