package dm.sample.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class TvShowsDestination {

    object TvShows : TvShowsDestination() {
        val route = "tvshows_screen"
    }

    object TvShowDetails : TvShowsDestination() {

        const val DETAILS_KEY = "shows_details_id"
        val route = "tvshow_details_screen/{$DETAILS_KEY}"
        val navArguments =  listOf(navArgument(DETAILS_KEY) {
            type = NavType.LongType
        })

        fun tvShowDetails(showId: Long) = object : NavigationCommand {
            override val destination: String
                get() = "tvshow_details_screen/{$showId}"

            override val arguments: List<NamedNavArgument>
                get() = navArguments

        }
    }
}
