package com.example.examproject;

import com.example.examproject.model.Task;
import com.example.examproject.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class TaskRepositoryTest {


    @Autowired
    private TaskRepository taskRepository;

    private Task task;

   /* @BeforeEach
    public void setUp() {
        task = new Task();
        task.setSubProject_Id(1);
        task.setDescription("Test Task");
        task.setStatus("In Progress");
        task.setPriority("High");
        task.setEstimatedTime(5);
    }

    @Test
    public void testCreateTask() {
        Task createdTask = taskRepository.createTask(task);

        assertNotNull(createdTask);
        assertNotNull(createdTask.getId());
        assertEquals("Test Task", createdTask.getDescription());
    }

    @Test
    public void testGetAllTasks() {
        taskRepository.createTask(task);

        List<Task> tasks = taskRepository.getAllTasks(1);

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
    }

    @Test
    public void testUpdateTask() {
        Task createdTask = taskRepository.createTask(task);

        createdTask.setDescription("Updated Task Description");
        Task updatedTask = taskRepository.updateTask(createdTask);

        assertEquals("Updated Task Description", updatedTask.getDescription());
    }

    @Test
    public void testDeleteTask() {
        Task createdTask = taskRepository.createTask(task);

        int taskId = createdTask.getId();

        taskRepository.deleteTask(taskId);
        Task deletedTask = taskRepository.getTaskById(taskId);

        assertNull(deletedTask);
    }

    @Test
    void getTaskById() {
        int testTaskId = 1; //

        Task task = taskRepository.getTaskById(testTaskId);

        assertNotNull(task);
        assertEquals(testTaskId, task.getId());
        assertEquals("Task A1-1", task.getDescription());
    }*/
}