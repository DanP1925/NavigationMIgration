package com.danp1925.navigationmigration

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.fragment.fragment

@Composable
fun makeMainGraph(navController: NavHostController, updateToolbar: (String) -> Unit) {
    return NavHost(
        navController = navController,
        startDestination = NavRoutes.First
    ) {
        addFirstScreen(updateToolbar)
    }
}

private fun NavGraphBuilder.addFirstScreen(updateToolbar: (String) -> Unit) {
    composable<NavRoutes.First> {
        FirstScreen(
            updateToolbar,
            {},
            {}
        )
    }
}

private fun NavGraphBuilder.addSecondScreen() {
    fragment<SecondFragment, NavRoutes.Second> {
        label = "Second"
    }
}

private fun NavGraphBuilder.addThirdScreen() {
    fragment<ThirdFragment, NavRoutes.Third> {
        label = "Third"
    }
}