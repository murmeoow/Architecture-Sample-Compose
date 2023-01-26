package dm.sample.feature_tvshows.data.repository

import dm.sample.feature_tvshows.data.mapper.toDomain
import dm.sample.feature_tvshows.data.remote.api.TvShowsApi
import dm.sample.feature_tvshows.domain.model.TvShow
import dm.sample.feature_tvshows.domain.repository.TvShowsRepository
import javax.inject.Inject

class TvShowsRepositoryImpl @Inject constructor(
    private val tvShowsApi: TvShowsApi
): TvShowsRepository {

    override suspend fun getAllTvShows(): List<TvShow> {
        return tvShowsApi.getAllShows().map {
            it.toDomain()
        }
    }

    override suspend fun getShowById(id: Long): TvShow {
        return tvShowsApi.getTvShow(showId = id).toDomain()
    }

}