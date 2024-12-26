package com.danp1925.navigationmigration

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private val mainViewModel: MainViewModel by activityViewModels()
    private val args: ThirdFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainViewModel.updateToolbar("Third Screen")

        view.findViewById<TextView>(R.id.third_argument).apply {
            text = "Number from previous screen: ${args.numberArgument}"
        }
    }

}