package com.example.examproject.controller;
import com.example.examproject.model.Project;
import com.example.examproject.model.Subproject;
import com.example.examproject.model.Task;
import com.example.examproject.model.User;
import com.example.examproject.service.ProjectService;
import com.example.examproject.service.SubprojectService;
import com.example.examproject.service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    private SubprojectService subprojectService;
    private TaskService taskService;
    private ProjectService projectService;

    public ProjectController(ProjectService projectService, SubprojectService subprojectService, TaskService taskService) {
        this.projectService = projectService;
        this.subprojectService = subprojectService;
        this.taskService = taskService;
    }

    @GetMapping("/create_project")
    public String createProjectform(Model model) {
        model.addAttribute("projectObject", new Project());
        return "create_project";
    }

    @PostMapping("/create_project")
    public String createProject(@ModelAttribute Project project, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        project.setUsers_id(user.getid());
        projectService.createProject(project);
        return "redirect:/projects";
    }

   @GetMapping("/project_frontpage")
    public String projectFrontpage(Model model) {
        model.addAttribute("projectObject", new Project());
        return "project_frontpage";
    }


    @GetMapping("/projects")
    public String getAllProjects(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        ArrayList<Project> projects = projectService.getAllProjects(user.getid());
        model.addAttribute("projects", projects);
        return "project_frontpage";
    }


    @GetMapping("/edit_project/{id}")
    public String showEditProjectForm(@PathVariable("id") int id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "edit_project";
    }

    @PostMapping("/edit_project/{id}")
    public String updateProject(Project project) {
        projectService.updateProject(project);
        return "redirect:/projects";
    }

    @GetMapping("/confirm_delete/{projectId}")
        public String confirmDelete(@PathVariable("projectId") int projectId, Model model) {
        model.addAttribute("projectId", projectId);
        return "confirm_delete";
    }

    @PostMapping("/deleteProject")
    public String deleteProject(@RequestParam("projectId") int projectId, Model model) {
        model.addAttribute("projectId", projectId);
        projectService.deleteProject(projectId);
        return "redirect:/projects";
    }


    @GetMapping("/project/{id}")
    public String viewProjectDetails(@PathVariable("id") int id, Model model, HttpSession session) {
        Project project = projectService.getProjectById(id);
        List<Subproject> subprojects = subprojectService.getAllSubprojects(id);
        Task task = taskService.getTaskById(id);
        session.setAttribute("currentProjectId", id);
        model.addAttribute("project", project);
        model.addAttribute("subprojects", subprojects);
        model.addAttribute("task", task);
        return "subprojects";
    }
}


