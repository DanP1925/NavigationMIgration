package com.danp1925.navigationmigration

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FirstFragment : Fragment(R.layout.fragment_first){

    private val mainViewModel : MainViewModel by activityViewModels()
    private lateinit var secondButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainViewModel.updateToolbar("First Screen")

        secondButton = view.findViewById(R.id.second_button)
        secondButton.setOnClickListener {
            mainViewModel.navigateToSecondScreen()
        }
    }

}