package dm.sample.feature_tvshows.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import dm.sample.core.navigation.NavigationFactory
import dm.sample.feature_tvshows.presentation.TvShowDetailsNavigationFactory
import dm.sample.feature_tvshows.presentation.TvShowsNavigationFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface TvShowsModule {

    @Singleton
    @Binds
    @IntoSet
    fun bindTvShowsNavigationFactory(factory: TvShowsNavigationFactory): NavigationFactory

    @Singleton
    @Binds
    @IntoSet
    fun bindTvShowDetailsNavigationFactory(factory: TvShowDetailsNavigationFactory): NavigationFactory

}