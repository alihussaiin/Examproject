package com.example.examproject.service;


import com.example.examproject.model.Project;
import com.example.examproject.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.createProject(project);
    }


    public ArrayList<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }


//    public Project updateProject(int id, Project updateProject) {
//        return projectRepository.updateProject(updateProject);
//    }

    public void updateProject(Project updateProject) {
        projectRepository.updateProject(updateProject);
    }

    public void deleteProject(int id) {

        projectRepository.deleteProject(id);
    }


}





