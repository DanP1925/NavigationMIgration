package com.danp1925.navigationmigration

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment

fun makeMainGraph(navController: NavController) = navController.createGraph(
    startDestination = NavRoutes.First
) {
    addFirstScreen()
    addSecondScreen()
    addThirdScreen()
}

private fun NavGraphBuilder.addFirstScreen() {
    fragment<FirstFragment, NavRoutes.First> {
        label = "First"
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