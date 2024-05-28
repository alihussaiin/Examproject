package com.example.examproject;

import com.example.examproject.model.Project;
import com.example.examproject.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository repository;


    private Project project;

    /*@BeforeEach
    public void setUp() {
        project = new Project();
        project.setUsers_id(5);
        project.setName("Projekt");
        project.setDescription("Test test test");
        project.setStatus("Påbegyndt");
        project.setStartDate(LocalDate.now());
        project.setEndDate(LocalDate.now().plusDays(10));
    }

    @Test
    public void testCreateProject() {
        Project createdProject = repository.createProject(project);

        assertNotNull(createdProject);
        assertNotNull(createdProject.getId());
        assertEquals("Projekt", createdProject.getName());
    }

    @Test
    public void testGetAllProjects() {
        repository.createProject(project);

        List<Project> projects = repository.getAllProjects(1);

        assertNotNull(projects);
        assertFalse(projects.isEmpty());
    }

    @Test
    public void testUpdateProject() {
        Project createdProject = repository.createProject(project);

        createdProject.setName("Projekt");
        Project updatedProject = repository.updateProject(createdProject);

        assertEquals("Projekt", updatedProject.getName());
    }

    @Test
    public void testDeleteProject() {
        Project createdProject = repository.createProject(project);

        int projectId = createdProject.getId();
        repository.deleteProject(projectId);
        Project deletedProject = repository.getProjectById(projectId);

        assertNull(deletedProject);
    }

    @Test
    void getProjectById() {

        int testProjectId = 5;


        Project project = repository.getProjectById(testProjectId);

        assertNotNull(project);
        assertEquals(testProjectId, project.getId());
        assertEquals("Projekt", project.getName());
    }*/



}