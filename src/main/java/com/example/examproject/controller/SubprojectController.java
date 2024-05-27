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


        @GetMapping("/create_subproject/{projectId}")
        public String createSubprojectForm(@PathVariable("projectId") int projectId, Model model, HttpSession session) {
            model.addAttribute("subprojectObject", new Subproject());

            session.setAttribute("currentProjectId", projectId); // Set projectId in session
            return "create_subproject";
        }


        @PostMapping("/create_subproject")
        public String createSubproject(@ModelAttribute Subproject subproject, HttpSession session) {
            Integer projectId = (Integer) session.getAttribute("currentProjectId");
            subproject.setProjectId(projectId);
            subprojectService.createSubproject(subproject);
            return "redirect:/project/" + projectId;
        }


        @GetMapping("/subprojects/{projectId}")
        public String getAllSubprojects(@PathVariable("projectId") int projectId, Model model, HttpSession session) {
            model.addAttribute("id", projectId);
            session.setAttribute("currentProjectId", projectId);
            System.out.println(projectId);// Set projectId in session
            List<Subproject> subprojects = subprojectService.getAllSubprojects(projectId);
            model.addAttribute("subprojects", subprojects);
            return "subprojects";
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

        @GetMapping("/confirm_delete_subproject/{subprojectId}/{projectId}")
        public String confirmDeleteSubproject(@PathVariable("subprojectId") int subprojectId, @PathVariable("projectId") int projectId, Model model) {
            Subproject subproject = subprojectService.getSubprojectById(subprojectId);
            model.addAttribute("subprojectId", subprojectId);
            model.addAttribute("projectId", projectId);
            System.out.println(subprojectId + " " + projectId);
            return "confirm_delete_subproject";
        }

        @PostMapping("/deleteSubproject")
        public String deleteSubproject(@RequestParam("subprojectId") int subprojectId, @RequestParam("projectId") int projectId) {
            System.out.println("subprojectId" + projectId);
            subprojectService.deleteSubproject(subprojectId);
            System.out.println("success");
            return "redirect:/project/" + projectId;
        }
    }
