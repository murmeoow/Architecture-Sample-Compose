package dm.sample.core.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManager @Inject constructor() {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private val navigationCommandChannel = Channel<NavigationEvent>(Channel.BUFFERED)
    val navigationEvent = navigationCommandChannel.receiveAsFlow()

    fun navigate(command: NavigationCommand) {
        scope.launch {
            navigationCommandChannel.send(NavigationEvent.Directions(command))
        }
    }

    fun popBackStack() {
        scope.launch {
            navigationCommandChannel.send(NavigationEvent.PopBackStack)
        }
    }

    fun navigateUp() {
        scope.launch {
            navigationCommandChannel.send(NavigationEvent.NavigateUp)
        }
    }

}