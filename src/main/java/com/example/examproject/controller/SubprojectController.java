package com.example.examproject.controller;

import com.example.examproject.model.Subproject;
import com.example.examproject.service.SubprojectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    public class SubprojectController {

        private SubprojectService subprojectService;

        public SubprojectController(SubprojectService subprojectService) {
            this.subprojectService = subprojectService;
        }


        @GetMapping("/create_subproject/{id}")
        public String createSubprojectForm(Model model) {
            model.addAttribute("subprojectObject", new Subproject());
            return "create_subproject";
        }

        @PostMapping("/create_subproject")
        public String createSubproject(@ModelAttribute Subproject subproject, HttpSession session) {
            // Få projektets ID fra sessionen og tilknyt det til det nye subprojekt
            Integer projectId = (Integer) session.getAttribute("currentProjectId");
            subproject.setProjectId(projectId);
            System.out.println("test");
            // Send subprojektet til subprojektets serviceklasse for at gemme det i databasen
            subprojectService.createSubproject(subproject);

            // Omdiriger brugeren til forsiden for subprojekter
            return "redirect:/project_details";
        }

        @GetMapping("/subproject_frontpage")
        public String subprojectFrontpage(Model model) {
            model.addAttribute("subprojectObject", new Subproject());
            return "subproject_frontpage";
        }

        @GetMapping("/subprojects")
        public String getAllSubprojects(Model model, HttpSession session) {
            Integer projectId = (Integer) session.getAttribute("currentProjectId");
            List<Subproject> subprojects = subprojectService.getAllSubprojects(projectId);
            model.addAttribute("subprojects", subprojects);
            return "subproject_frontpage";
        }

        @GetMapping("/edit_subproject/{id}")
        public String showEditSubprojectForm(@PathVariable("id") int id, Model model) {
            Subproject subproject = subprojectService.getSubprojectById(id);
            model.addAttribute("subproject", subproject);
            return "edit_subproject";
        }

        @PostMapping("/edit_subproject/{id}")
        public String updateSubproject(@ModelAttribute Subproject subproject) {
            subprojectService.updateSubproject(subproject);
            return "redirect:/subprojects";
        }

        @GetMapping("/confirm_delete_subproject/{id}")
        public String confirmDeleteSubproject(@PathVariable("id") int id, Model model) {
            model.addAttribute("subprojectId", id);
            return "confirm_delete_subproject";
        }

        @PostMapping("/deleteSubproject")
        public String deleteSubproject(@RequestParam("subprojectId") int id, Model model) {
            subprojectService.deleteSubproject(id);
            return "redirect:/subproject";
        }







    }
