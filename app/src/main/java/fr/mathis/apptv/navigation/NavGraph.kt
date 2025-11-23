package fr.mathis.apptv.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import fr.mathis.apptv.ui.screens.DetailScreen
import fr.mathis.apptv.ui.screens.HomeScreen
import fr.mathis.apptv.ui.screens.SearchScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onShowClick = { showId ->
                    navController.navigate(Screen.Detail.createRoute(showId))
                },
                onSearchClick = {
                    navController.navigate(Screen.Search.route)
                }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("showId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val showId = backStackEntry.arguments?.getInt("showId") ?: 0
            DetailScreen(
                showId = showId,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Screen.Search.route) {
            SearchScreen(
                onShowClick = { showId ->
                    navController.navigate(Screen.Detail.createRoute(showId))
                },
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

