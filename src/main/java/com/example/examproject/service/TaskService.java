package com.example.examproject.service;

import com.example.examproject.model.Task;
import com.example.examproject.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task createTask(Task task) {
        return taskRepository.createTask(task);
    }

    public List<Task> getAllTasks(int subProjectId) {
        return taskRepository.getAllTasks(subProjectId);
    }

    public Task updateTask(Task task) {
        return taskRepository.updateTask(task);
    }

    public void deleteTask(int taskId) {
        taskRepository.deleteTask(taskId);
    }

    public Task getTaskById(int taskId) {
        return taskRepository.getTaskById(taskId);
    }
}
