package com.danp1925.navigationmigration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.toRoute

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val secondRoute =
            findNavController().getBackStackEntry<NavRoutes.Second>()
                .toRoute<NavRoutes.Second>()


        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val composeView = view.findViewById<ComposeView>(R.id.second_compose_view)

        composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    SecondScreen(
                        stringArgument = secondRoute.stringArgument,
                        updateToolbar = mainViewModel::updateToolbar,
                        navigateToThirdScreen = mainViewModel::navigateFromSecondToThirdScreen
                    )
                }
            }
        }
        return view
    }
}