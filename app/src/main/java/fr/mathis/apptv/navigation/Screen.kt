package fr.mathis.apptv.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Detail : Screen("detail/{showId}") {
        fun createRoute(showId: Int) = "detail/$showId"
    }
    data object Search : Screen("search")
}

