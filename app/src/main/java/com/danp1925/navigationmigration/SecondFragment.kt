package com.danp1925.navigationmigration

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.toRoute

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var thirdButton: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainViewModel.updateToolbar("Second Screen")

        val secondRoute =
            findNavController().getBackStackEntry<MainActivity.Second>()
                .toRoute<MainActivity.Second>()
        view.findViewById<TextView>(R.id.second_argument).apply {
            text = secondRoute.stringArgument
        }

        thirdButton = view.findViewById(R.id.third_button)
        thirdButton.setOnClickListener {
            mainViewModel.navigateFromSecondToThirdScreen()
        }
    }

}