package dm.sample.feature_tvshows.presentation.model

data class TvShowUi(
    val id: Long,
    val name: String,
    val imageUrl: String?,
    val summary: String,
    val genres: String,
    val language: String,
    val releaseDate: String,
    val rating: Double,
)