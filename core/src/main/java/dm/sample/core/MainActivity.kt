package dm.sample.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dm.sample.core.extensions.collectWithLifecycle
import dm.sample.core.navigation.NavigationEvent
import dm.sample.core.navigation.NavigationFactory
import dm.sample.core.navigation.NavigationHost
import dm.sample.core.navigation.NavigationManager
import dm.sample.core.ui.theme.ArchitectureSampleTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationFactories: @JvmSuppressWildcards Set<NavigationFactory>

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitectureSampleTheme {
                val navController = rememberNavController()

                Scaffold {
                    NavigationHost(
                        modifier = Modifier.padding(it),
                        navController = navController,
                        factories = navigationFactories
                    )
                }

                navigationManager
                    .navigationEvent
                    .collectWithLifecycle(
                        key = navController
                    ) { event ->
                        when (event) {
                            is NavigationEvent.Directions -> {
                                navController.navigate(event.command.destination, event.command.configuration)
                            }
                            NavigationEvent.NavigateUp -> navController.navigateUp()
                            NavigationEvent.PopBackStack -> navController.popBackStack()
                        }
                    }
            }
        }
    }
}
