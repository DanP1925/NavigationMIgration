package com.danp1925.navigationmigration

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

@Composable
fun makeMainGraph(navController: NavHostController) {
    return NavHost(
        navController = navController,
        startDestination = NavRoutes.First
    ) {
        addFirstScreen(navController)
        addSecondScreen(navController)
        addThirdScreen()
    }
}

private fun NavGraphBuilder.addFirstScreen(
    navController: NavHostController
) {
    composable<NavRoutes.First> {
        FirstScreen(
            navigateToSecondScreen = {
                navController.navigate(
                    NavRoutes.Second(stringArgument = "String from First Screen")
                )
            },
            navigateToThirdScreen = {
                navController.navigate(
                    NavRoutes.Third(numberArgument = 1)
                )
            }
        )
    }
}

private fun NavGraphBuilder.addSecondScreen(
    navController: NavHostController
) {
    composable<NavRoutes.Second> { backStackEntry ->
        val secondRoute: NavRoutes.Second = backStackEntry.toRoute()
        SecondScreen(
            stringArgument = secondRoute.stringArgument,
            navigateToThirdScreen = {
                navController.navigate(
                    NavRoutes.Third(numberArgument = 2)
                )
            }
        )
    }
}

private fun NavGraphBuilder.addThirdScreen() {
    composable<NavRoutes.Third> { backStackEntry ->
        val thirdRoute: NavRoutes.Third = backStackEntry.toRoute()
        ThirdScreen(
            numberArgument = thirdRoute.numberArgument
        )
    }
}