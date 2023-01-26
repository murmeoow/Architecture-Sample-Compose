package dm.sample.feature_tvshows.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dm.sample.core.navigation.TvShowsDestination
import dm.sample.core.navigation.NavigationFactory
import dm.sample.feature_tvshows.presentation.composables.details.TvShowDetailsScreen
import javax.inject.Inject

class TvShowDetailsNavigationFactory @Inject constructor() : NavigationFactory{

    override fun create(builder: NavGraphBuilder) {
        builder.composable(TvShowsDestination.TvShowDetails.route) {
            TvShowDetailsScreen()
        }
    }
}