package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Damian on 05.05.2020 21:38
 */

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest{

    @Test
    fun addNewTask_setNewTaskEvent(){
        // Given a fresh TasksViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())


        // When adding a new task


        // Then the new task event is triggered
    }
}