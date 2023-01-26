package dm.sample.feature_tvshows.domain.usecase

import dm.sample.core.extensions.resultOf
import dm.sample.feature_tvshows.domain.model.TvShow
import dm.sample.feature_tvshows.domain.repository.TvShowsRepository
import javax.inject.Inject

class GetAllTvShowsUseCase @Inject constructor(
    private val tvShowsRepository: TvShowsRepository
) {

    suspend fun invoke(): Result<List<TvShow>> = resultOf {
        tvShowsRepository.getAllTvShows()
    }
}