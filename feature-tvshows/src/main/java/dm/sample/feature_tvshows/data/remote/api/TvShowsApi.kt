package dm.sample.feature_tvshows.data.remote.api

import dm.sample.feature_tvshows.data.remote.models.TvShowItemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TvShowsApi {

    @GET("shows")
    suspend fun getAllShows(): ArrayList<TvShowItemResponse>

    @GET("shows/{show_id}")
    suspend fun getTvShow(
        @Path("show_id") showId: Long,
    ): TvShowItemResponse
}