package com.example.examproject;

import com.example.examproject.model.Task;
import com.example.examproject.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository repository;

    @Test
    void getTaskById() {
        // Arrange
        int testTaskId = 1; //

        // Act
        Task task = repository.getTaskById(testTaskId);

        // Assert
        assertNotNull(task);
        assertEquals(testTaskId, task.getId());
        assertEquals("Task 1", task.getDescription());
    }
    }


