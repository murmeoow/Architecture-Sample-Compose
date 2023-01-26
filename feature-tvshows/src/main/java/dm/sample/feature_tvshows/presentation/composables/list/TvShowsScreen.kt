package dm.sample.feature_tvshows.presentation.composables.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dm.sample.feature_tvshows.presentation.TvShowsUiEvent
import dm.sample.feature_tvshows.presentation.TvShowsViewModel
import dm.sample.feature_tvshows.presentation.composables.TvShowsLoadingContent

@Composable
fun TvShowsScreen(
    viewModel: TvShowsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    when {
        state.isLoading -> TvShowsLoadingContent()
        state.isError -> {
            Box(modifier = Modifier.fillMaxSize().background(Color.Red))
        }
        else -> Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            TvShowsListContent(
                tvShows = state.tvShows,
                state = rememberLazyGridState(),
                contentPadding = PaddingValues(horizontal = 24.dp),
                onTvShowClick = { viewModel.onEvent(TvShowsUiEvent.GoToDetails(it)) }
            )
        }
    }
}