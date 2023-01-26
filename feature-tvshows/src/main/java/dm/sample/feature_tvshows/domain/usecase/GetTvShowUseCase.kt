package dm.sample.feature_tvshows.domain.usecase

import dm.sample.core.extensions.resultOf
import dm.sample.feature_tvshows.domain.model.TvShow
import dm.sample.feature_tvshows.domain.repository.TvShowsRepository
import javax.inject.Inject

class GetTvShowUseCase @Inject constructor(
    private val tvShowsRepository: TvShowsRepository
) {
    suspend fun invoke(showId: Long): Result<TvShow> = resultOf {
        tvShowsRepository.getShowById(showId)
    }
}