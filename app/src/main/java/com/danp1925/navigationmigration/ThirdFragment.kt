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

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val thirdRoute =
            findNavController().getBackStackEntry<NavRoutes.Third>()
                .toRoute<NavRoutes.Third>()

        val view = inflater.inflate(R.layout.fragment_third,container,false)
        val composeView = view.findViewById<ComposeView>(R.id.third_compose_view)

        composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    ThirdScreen(
                        numberArgument = thirdRoute.numberArgument,
                        updateToolbar = mainViewModel::updateToolbar
                    )
                }
            }
        }

        return view
    }

}