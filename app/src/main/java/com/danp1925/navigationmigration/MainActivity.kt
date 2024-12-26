package com.danp1925.navigationmigration

import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var toolbar: Toolbar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment
        navController = navHostFragment.navController
        navController.graph = makeNavigationGraph()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    mainViewModel.toolbarTitle.collect { toolbarTitle ->
                        toolbar.title = toolbarTitle
                    }
                }
                launch {
                    mainViewModel.events.collect { event ->
                        when (event) {
                            is MainEvents.NavigateToSecondScreen -> navigateToSecondScreen(event.stringArgument)
                            is MainEvents.NavigateFromFirstToThirdScreen -> navigateFromFirstToThirdScreen()
                            is MainEvents.NavigateFromSecondToThirdScreen -> navigateFromSecondToThirdScreen()
                        }
                    }
                }
            }
        }
    }

    private fun makeNavigationGraph() = makeMainGraph(navController)

    private fun navigateToSecondScreen(valueToPass: String) {
        navController.navigate(route = NavRoutes.Second(stringArgument = valueToPass))
    }

    private fun navigateFromFirstToThirdScreen() {
        navController.navigate(route = NavRoutes.Third(numberArgument = 1))
    }

    private fun navigateFromSecondToThirdScreen() {
        navController.navigate(route = NavRoutes.Third(numberArgument = 2))
    }
}