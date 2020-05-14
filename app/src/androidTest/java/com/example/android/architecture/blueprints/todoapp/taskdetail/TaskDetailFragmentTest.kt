package com.example.android.architecture.blueprints.todoapp.taskdetail

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.ServiceLocator
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.FakeAndroidTestRepository
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Damian on 11.05.2020 21:31
 */

@RunWith(AndroidJUnit4::class)
@MediumTest
@ExperimentalCoroutinesApi
class TaskDetailFragmentTest {

    private lateinit var tasksRepository: TasksRepository

    @Before
    fun initRepository() {
        tasksRepository = FakeAndroidTestRepository()
        ServiceLocator.tasksRepository = tasksRepository
    }

    @After
    fun cleanupDatabase() = runBlockingTest {
        ServiceLocator.resetRepository()
    }

    @Test
    fun activeTaskDetail_DisplayedInUi() = runBlockingTest {
        //GIVEN - Add active (incomplete) task to the DB
        val activeTask = Task(" Active task", "AndroidX Rocks!!", false)

        tasksRepository.saveTask(activeTask)

        //WHEN - Details fragment launched to display task
        val bundle = TaskDetailFragmentArgs(activeTask.id).toBundle()
        launchFragmentInContainer<TaskDetailFragment>(bundle, R.style.AppTheme)
    }
}