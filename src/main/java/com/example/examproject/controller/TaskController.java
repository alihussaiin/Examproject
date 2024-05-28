package com.example.examproject.controller;

import com.example.examproject.model.Subproject;
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

    @GetMapping("/create_task/{subprojectId}")
    public String createTaskForm(@PathVariable("subprojectId") int subprojectId, Model model, HttpSession session) {
        model.addAttribute("taskObject", new Task());
        session.setAttribute("subprojectId", subprojectId);
        return "create_task";
    }


    @PostMapping("/create_task")
    public String createTask(@ModelAttribute Task task, HttpSession session) {
        Integer subprojectId = (Integer) session.getAttribute("subprojectId");
        task.setSubProject_Id(subprojectId);
        taskService.createTask(task);
        return "redirect:/tasks/" + subprojectId;
    }


    @GetMapping("/tasks/{subprojectId}")
    public String getAllTasks(@PathVariable("subprojectId") int subprojectId, Model model) {
        List<Task> tasks = taskService.getAllTasks(subprojectId);
        model.addAttribute("tasks", tasks);
        model.addAttribute("subprojectId", subprojectId);
        return "tasks";
    }

    @GetMapping("/edit_task/{id}")
    public String showEditTaskForm(@PathVariable("id") int id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "edit_task";
    }

    @PostMapping("/edit_task/{subprojectId}")
    public String updateTask(@PathVariable ("subprojectId") int subprojectId,Model model,@ModelAttribute Task task) {
        model.addAttribute("subprojectId", subprojectId);
        taskService.updateTask(task);
        System.out.println(subprojectId);
        return "redirect:/tasks/" + subprojectId;
    }

    @GetMapping("/confirm_delete_task/{id}/{subprojectId}")
    public String confirmDelete(@PathVariable("id") int taskId, @PathVariable("subprojectId") int subprojectId, Model model) {
        model.addAttribute("taskId", taskId);
        model.addAttribute("subprojectId", subprojectId);
        return "confirm_delete_task";
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") int taskId, @RequestParam("subprojectId") int subprojectId) {
        taskService.deleteTask(taskId);
        return "redirect:/tasks/" + subprojectId;
    }

}




