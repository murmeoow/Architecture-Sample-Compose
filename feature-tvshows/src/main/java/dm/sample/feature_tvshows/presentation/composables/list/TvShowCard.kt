package dm.sample.feature_tvshows.presentation.composables.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import dm.sample.feature_tvshows.presentation.model.TvShowUi

@Composable
fun TvShowCard(
    tvShow: TvShowUi,
    modifier: Modifier = Modifier,
    onClick: (Long) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier.clickable(onClick = { onClick(tvShow.id) },)
    ) {
        Box {
            SubcomposeAsyncImage(
                model = tvShow.imageUrl,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                contentDescription = "TvShow card cover",
            )
            Card(
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp)
                    .height(24.dp),
                shape = RoundedCornerShape(6.dp),
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Text(
                    text = "%.1f".format(tvShow.rating),
                    style = MaterialTheme.typography.overline,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                )
            }
        }
    }
}