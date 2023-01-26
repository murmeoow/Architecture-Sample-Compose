package dm.sample.feature_tvshows.domain.model

data class TvShow(
    val id: Long,
    val name: String,
    val summary: String,
    val genres: List<String>,
    val imagePathUrl: String?,
    val language: String,
    val premiered: String,
    val ended: String?,
    val imdbId: String?,
    val rating: Double,
    val status: String,
)