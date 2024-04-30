package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProjectManagerService;

@Controller
@RequestMapping(path = "")
public class ProjectManagerController {
    private final ProjectManagerService projectManagerService;

    public ProjectManagerController(ProjectManagerService projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    @GetMapping("")
    public String home() {
        // Tilføj eventuelle data til model, som skal vises i visningen
        return "index";
    }
}
