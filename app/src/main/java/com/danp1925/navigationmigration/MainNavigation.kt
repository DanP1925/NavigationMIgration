package com.danp1925.navigationmigration

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

@Composable
fun makeMainGraph(navController: NavHostController, updateToolbar: (String) -> Unit) {
    return NavHost(
        navController = navController,
        startDestination = NavRoutes.First
    ) {
        addFirstScreen(navController, updateToolbar)
        addSecondScreen(navController, updateToolbar)
        addThirdScreen(updateToolbar)
    }
}

private fun NavGraphBuilder.addFirstScreen(
    navController: NavHostController,
    updateToolbar: (String) -> Unit
) {
    composable<NavRoutes.First> {
        FirstScreen(
            updateToolbar = updateToolbar,
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
    navController: NavHostController,
    updateToolbar: (String) -> Unit
) {
    composable<NavRoutes.Second> { backStackEntry ->
        val secondRoute: NavRoutes.Second = backStackEntry.toRoute()
        SecondScreen(
            stringArgument = secondRoute.stringArgument,
            updateToolbar = updateToolbar,
            navigateToThirdScreen = {
                navController.navigate(
                    NavRoutes.Third(numberArgument = 2)
                )
            }
        )
    }
}

private fun NavGraphBuilder.addThirdScreen(updateToolbar: (String) -> Unit) {
    composable<NavRoutes.Third> { backStackEntry ->
        val thirdRoute: NavRoutes.Third = backStackEntry.toRoute()
        ThirdScreen(
            numberArgument = thirdRoute.numberArgument,
            updateToolbar = updateToolbar
        )
    }
}