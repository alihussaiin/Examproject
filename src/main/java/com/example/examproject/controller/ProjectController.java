package com.example.examproject.controller;

import com.example.examproject.model.Project;
import com.example.examproject.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //opret projekt og går hen til stien createProject
    @GetMapping("/create_project")
    public String createProjectform(Model model) {
        model.addAttribute("project", new Project());
        return "create_project";
    }

    //modtager datainput fra brugeren og sender dataen til databasen
    @PostMapping("/create_project")
    public String createProject(@ModelAttribute Project project) {
        projectService.createProject(project);
        return "redirect:/project_frontpage";
    }

    // Opret en side for visning af alle projekter
    @GetMapping("/projects")
    public String getAllProjects(Model model) {
        ArrayList<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "project_frontpage";
    }


    @PostMapping("/projects/{id}")
    public String updateProject(@PathVariable("id") int id, @ModelAttribute Project project) {
        projectService.updateProject(project);
        return "redirect:/project_frontpage";
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable("id") int id, Model model) {
        projectService.deleteProject(id);
        model.addAttribute("project");
        return "projectID"; // returnerer en view med information om det arkiverede projekt
    }


}
