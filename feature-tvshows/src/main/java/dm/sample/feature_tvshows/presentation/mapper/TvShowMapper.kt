package dm.sample.feature_tvshows.presentation.mapper

import dm.sample.feature_tvshows.domain.model.TvShow
import dm.sample.feature_tvshows.presentation.model.TvShowUi

fun TvShow.toUi() = TvShowUi(
    id = id,
    name = name,
    summary = summary,
    releaseDate = "$premiered - ${ended ?: "..."}",
    genres = genres.joinToString(", ") { it },
    imageUrl = imagePathUrl,
    rating = rating,
    language = language
)