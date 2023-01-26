package dm.sample.feature_tvshows.presentation.composables.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import dm.sample.feature_tvshows.presentation.composables.Header
import dm.sample.feature_tvshows.presentation.model.TvShowUi

@Composable
fun TvShowDetailsContent(
    tvShow: TvShowUi,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Header(
            onBackClick = onBackClick,
            hasBackClick = true
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 24.dp)
        ) {
            SubcomposeAsyncImage(
                model = tvShow.imageUrl,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().padding(top = 24.dp),
                contentDescription = "TvShow card cover",
            )
        }
        Text(
            text = tvShow.name,
            style = MaterialTheme.typography.h6.copy(
                lineHeight = 21.6.sp
            ),
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(top = 14.dp, start = 24.dp, end = 24.dp)
        )
        Text(
            text = tvShow.releaseDate,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(top = 8.dp, start = 24.dp, end = 24.dp, bottom = 20.dp)
        )
        Text(
            text = tvShow.summary,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}