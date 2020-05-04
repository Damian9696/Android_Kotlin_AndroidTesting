package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * Created by Damian on 04.05.2020 21:10
 */
class StatisticsUtilsTest {

    //One active task.
    //There are 100% percentage active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // GIVEN a list of tasks with a single, active, task
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = false)
        )

        // WHEN call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 0% completed tasks and 100% active tasks
        // Hamcrest implementation
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    //Two completed tasks and three active tasks.
    //There are 40% percentage completed and 60% active tasks.
    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {

        //Create and active tasks (the false make this active)
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = false)
        )

        //Call function to get result
        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 40f)
        assertEquals(result.activeTasksPercent, 60f)
    }


    //Empty list of active and completed tasks.
    //There are 0% percentage active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_emptyList_returnsHundredZero() {

        //Create and active tasks (the false make this active)
        val tasks = emptyList<Task>()

        //Call function to get result
        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    //Null list of active and completed tasks.
    //There are 0% percentage active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_null_returnsHundredZero() {

        //Create and active tasks (the false make this active)
        val tasks = null

        //Call function to get result
        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }
}