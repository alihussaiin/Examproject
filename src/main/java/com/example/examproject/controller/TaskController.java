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
    public String createTaskForm(@PathVariable("subProjectId") int subProjectId, Model model, HttpSession session) {
        model.addAttribute("taskObject", new Task());
        session.setAttribute("subProjectId", subProjectId); // Ensure subProjectId is in session
        return "create_task";
    }

    @PostMapping("/create_task")
    public String createTask(@ModelAttribute Task task, HttpSession session) {
        Integer subProjectId = (Integer) session.getAttribute("subProjectId");
        task.setSubProject_Id(subProjectId);
        taskService.createTask(task);
        return "redirect:/tasks/" + subProjectId;
    }


    @GetMapping("/tasks/{subProjectId}")
    public String getAllTasks(@PathVariable("subProjectId") int subProjectId, Model model) {
        List<Task> tasks = taskService.getAllTasks(subProjectId);
        model.addAttribute("tasks", tasks);
        model.addAttribute("subProjectId", subProjectId);
        return "tasks";
    }

    @GetMapping("/edit_task/{id}")
    public String showEditTaskForm(@PathVariable("id") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "tasks";
    }

    @PostMapping("/edit_task/{id}")
    public String updateTask(Task task) {
        taskService.updateTask(task);
        return "redirect:/tasks/" + task.getSubProject_Id();
    }

    @GetMapping("/confirm_delete_task/{id}/{subProjectId}")
    public String confirmDelete(@PathVariable("id") int taskId, @PathVariable("subProjectId") int subProjectId, Model model) {
        model.addAttribute("taskId", taskId);
        model.addAttribute("subProjectId", subProjectId);
        return "confirm_delete_task";
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") int taskId, @RequestParam("subProjectId") int subProjectId) {
        taskService.deleteTask(taskId);
        return "redirect:/tasks/" + subProjectId;
    }

}




