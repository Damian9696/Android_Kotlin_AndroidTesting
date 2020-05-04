package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Damian on 04.05.2020 21:10
 */
class StatisticsUtilsTest{

    //One active task.
    //There are 100% percentage active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        //Create and active tasks (the false make this active)
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = false)
        )

        //Call function to get result
        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)
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
}