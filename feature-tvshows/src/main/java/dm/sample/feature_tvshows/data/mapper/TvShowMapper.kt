package dm.sample.feature_tvshows.data.mapper

import dm.sample.feature_tvshows.data.remote.models.TvShowItemResponse
import dm.sample.feature_tvshows.domain.model.TvShow

fun TvShowItemResponse.toDomain() = TvShow(
    id = id,
    name = name,
    summary = summary,
    genres = genres,
    imagePathUrl = image.original,
    language = language,
    premiered = premiered,
    ended = ended,
    imdbId = externals.imdb,
    rating = rating.average,
    status = status,
)