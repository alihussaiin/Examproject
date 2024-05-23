package com.example.examproject.controller;

import com.example.examproject.model.Task;
import com.example.examproject.service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/create_task/{subProjectId}")
    public String createTaskForm(Model model) {
        model.addAttribute("taskObject", new Task());
        return "create_task";
    }

    @PostMapping("/create_task")
    public String createTask(@ModelAttribute Task task, HttpSession session) {
        int subProjectId = (int) session.getAttribute("subProjectId");
        task.setSubProject_Id(subProjectId);
        taskService.createTask(task);
        return "redirect:/subproject/" + subProjectId;
    }

    @GetMapping("/tasks/{subProjectId}")
    public String getAllTasks(@PathVariable("subProjectId") int subProjectId, Model model) {
        List<Task> tasks = taskService.getAllTasks(subProjectId);
        model.addAttribute("tasks", tasks);
        model.addAttribute("subProjectId", subProjectId);
        return "task_list";
    }

    @GetMapping("/edit_task/{id}")
    public String showEditTaskForm(@PathVariable("id") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "edit_task";
    }

    @PostMapping("/edit_task/{id}")
    public String updateTask(Task task) {
        taskService.updateTask(task);
        return "redirect:/subproject/" + task.getSubProject_Id();
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") int id, @RequestParam("subProjectId") int subProjectId ) {
        taskService.deleteTask(id);
        return "redirect:/subproject/" + subProjectId;
    }
}