package com.example.examproject.controller;
import com.example.examproject.model.Project;
import com.example.examproject.model.User;
import com.example.examproject.service.ProjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/confirm_delete/{id}")
    public String confirmDelete(@PathVariable("id") int id, Model model) {
        //subproject
        //task
        model.addAttribute("projectId", id);
        return "confirm_delete";
    }


    @PostMapping("/deleteProject")
    public String deleteProject(@RequestParam("projectId") int id, Model model) {
        projectService.deleteProject(id);
        model.addAttribute("project");
        return "redirect:/projects";

    }

}

