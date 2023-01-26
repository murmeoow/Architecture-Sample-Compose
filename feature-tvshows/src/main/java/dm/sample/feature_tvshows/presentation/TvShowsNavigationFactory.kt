package dm.sample.feature_tvshows.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dm.sample.core.navigation.TvShowsDestination
import dm.sample.core.navigation.NavigationFactory
import dm.sample.feature_tvshows.presentation.composables.list.TvShowsScreen
import javax.inject.Inject

class TvShowsNavigationFactory @Inject constructor(

) : NavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(TvShowsDestination.TvShows.route) {
            TvShowsScreen()
        }
    }
}