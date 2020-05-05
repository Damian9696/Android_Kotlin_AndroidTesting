package com.example.android.architecture.blueprints.todoapp.tasks


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.Event
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by Damian on 05.05.2020 21:38
 */

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addNewTask_setNewTaskEvent() {
        // Given a fresh TasksViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        //Create observer - no need for it to do anything
        val observer = Observer<Event<Unit>> {}
        try {

            //Observe LiveData forever
            tasksViewModel.newTaskEvent.observeForever(observer)

            // When adding a new task
            tasksViewModel.addNewTask()

            // Then the new task event is triggered
            val value = tasksViewModel.newTaskEvent.value
            assertThat(value?.getContentIfNotHandled(), (not(nullValue())))
        } finally {
            tasksViewModel.newTaskEvent.removeObserver(observer)
        }
    }

    @Test
    fun addNewTask_setsNewTaskEvent() {

        // Given a fresh ViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // When adding a new task
        tasksViewModel.addNewTask()

        // Then the new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(
                value.getContentIfNotHandled(), (not(nullValue()))
        )
    }
}