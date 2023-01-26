package dm.sample.feature_tvshows.presentation.composables.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dm.sample.feature_tvshows.R
import dm.sample.feature_tvshows.presentation.composables.Header
import dm.sample.feature_tvshows.presentation.model.TvShowUi

@Composable
fun TvShowsListContent(
    tvShows: List<TvShowUi>,
    state: LazyGridState,
    contentPadding: PaddingValues,
    onTvShowClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        Header(stringId = R.string.tv_shows_title)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = state,
            contentPadding = contentPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .background(MaterialTheme.colors.background)
                .padding(top = 20.dp)
        ) {
            items(tvShows.size) { index ->
                TvShowCard(
                    tvShow = tvShows[index],
                    onClick = {
                        onTvShowClick(tvShows[index].id)
                    },
                    modifier = Modifier
                        .height(248.dp)
                        .fillMaxWidth()
                )
            }
        }
    }

}
