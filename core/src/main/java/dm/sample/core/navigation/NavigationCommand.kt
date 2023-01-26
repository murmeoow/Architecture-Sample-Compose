package dm.sample.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavOptions

interface NavigationCommand {
    val destination: String
    val arguments: List<NamedNavArgument>
    val configuration: NavOptions
        get() = NavOptions.Builder().build()
}