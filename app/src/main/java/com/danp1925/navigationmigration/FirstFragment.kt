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

class FirstFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val composeView = view.findViewById<ComposeView>(R.id.first_compose_view)
        composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    FirstScreen(
                        updateToolbar = mainViewModel::updateToolbar,
                        navigateToSecondScreen = mainViewModel::navigateToSecondScreen,
                        navigateToThirdScreen = mainViewModel::navigateFromFirstToThirdScreen
                    )
                }
            }
        }
        return view
    }

}