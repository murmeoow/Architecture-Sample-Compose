package dm.sample.feature_tvshows.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dm.sample.feature_tvshows.data.remote.api.TvShowsApi
import dm.sample.feature_tvshows.data.repository.TvShowsRepositoryImpl
import dm.sample.feature_tvshows.domain.repository.TvShowsRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [ShowsModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object ShowsModule {

    @Provides
    @Singleton
    fun provideTvShowsApi(retrofit: Retrofit): TvShowsApi {
        return retrofit.create(TvShowsApi::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {

        @Binds
        @Singleton
        fun bindTvShowsRepository(impl: TvShowsRepositoryImpl): TvShowsRepository
    }
}