package dm.sample.feature_tvshows.data.remote.models

import com.google.gson.annotations.SerializedName

data class TvShowItemResponse(
    @SerializedName("ended")
    val ended: String?,
    @SerializedName("externals")
    val externals: Externals,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("id")
    val id: Long,
    @SerializedName("image")
    val image: Image,
    @SerializedName("language")
    val language: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("premiered")
    val premiered: String,
    @SerializedName("rating")
    val rating: Rating,
    @SerializedName("status")
    val status: String,
    @SerializedName("summary")
    val summary: String,
)

data class Rating(
    @SerializedName("average")
    val average: Double
)

data class Externals(
    @SerializedName("imdb")
    val imdb: String?,
)

data class Image(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String
)