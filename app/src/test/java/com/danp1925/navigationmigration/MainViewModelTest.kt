package com.danp1925.navigationmigration

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val sut by lazy {
        MainViewModel()
    }

    @Test
    fun `WHEN updateToolbar is called THEN update state with new title`() = runTest {
        val title = "test title"

        sut.updateToolbar(title)

        assertEquals(title, sut.toolbarTitle.value)
    }

    @Test
    fun `WHEN navigateToSecondScreen called THEN send respective event`() = runTest {
        val events = mutableListOf<MainEvents>()
        backgroundScope.launch(mainDispatcherRule.testDispatcher) {
            sut.events.toList(events)
        }
        sut.navigateToSecondScreen()

        assertTrue(events.first() is MainEvents.NavigateToSecondScreen)
    }

    @Test
    fun `WHEN navigateFromFirstToThirdScreen called THEN send respective event`() = runTest {
        val events = mutableListOf<MainEvents>()
        backgroundScope.launch(mainDispatcherRule.testDispatcher) {
            sut.events.toList(events)
        }
        sut.navigateFromFirstToThirdScreen()

        assertTrue(events.first() is MainEvents.NavigateFromFirstToThirdScreen)
    }

    @Test
    fun `WHEN navigateFromSecondToThirdScreen called THEN send respective event`() = runTest {
        val events = mutableListOf<MainEvents>()
        backgroundScope.launch(mainDispatcherRule.testDispatcher) {
            sut.events.toList(events)
        }
        sut.navigateFromSecondToThirdScreen()

        assertTrue(events.first() is MainEvents.NavigateFromSecondToThirdScreen)
    }

}