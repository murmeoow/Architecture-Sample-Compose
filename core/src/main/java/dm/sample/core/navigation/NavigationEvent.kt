package dm.sample.core.navigation

sealed class NavigationEvent {
    object NavigateUp : NavigationEvent()
    object PopBackStack : NavigationEvent()
    class Directions(
        val command: NavigationCommand,
    ) : NavigationEvent()
}