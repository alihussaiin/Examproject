package com.example.examproject.controller;
import com.example.examproject.model.Project;
import com.example.examproject.model.User;
import com.example.examproject.service.ProjectService;
import jakarta.servlet.http.HttpSession;
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
        model.addAttribute("projectObject", new Project());
        return "create_project";
    }

    @PostMapping("/create_project")
    public String createProject(@ModelAttribute Project project, HttpSession session) {
        // Få brugerens ID fra sessionen og tilknyt det til det nye projekt

        User user = (User) session.getAttribute("loggedInUser");
        project.setUsers_id(user.getid());
        // Send projektet til projektets serviceklasse for at gemme det i databasen
        projectService.createProject(project);

        // Omdiriger brugeren til forsiden for projekter
        return "redirect:/projects";
    }

   @GetMapping("/project_frontpage")
    public String projectFrontpage(Model model) {
        model.addAttribute("projectObject", new Project());
        return "project_frontpage";
    }


    // Opret en side for visning af alle projekter
    @GetMapping("/projects")
    public String getAllProjects(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        ArrayList<Project> projects = projectService.getAllProjects(user.getid());
        model.addAttribute("projects", projects);
        return "project_frontpage";
    }


    @PostMapping("/projects/{id}")
    public String updateProject(@PathVariable("id") int id, @ModelAttribute Project project) {
        projectService.updateProject(project);
        return "redirect:/projects";
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable("id") int id, Model model) {
        projectService.deleteProject(id);
        model.addAttribute("project");
        return "redirect:/projects"; // returnerer en view med information om det arkiverede projekt
    }


}

