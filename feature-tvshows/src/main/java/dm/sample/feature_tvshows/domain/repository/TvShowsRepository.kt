package dm.sample.feature_tvshows.domain.repository

import dm.sample.feature_tvshows.domain.model.TvShow

interface TvShowsRepository {

    suspend fun getAllTvShows(): List<TvShow>

    suspend fun getShowById(id: Long): TvShow
}