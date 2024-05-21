package com.example.examproject;

import com.example.examproject.model.Project;
import com.example.examproject.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository repository;




    @Test
    void getProjectById() {
        // Arrange
        int testProjectId = 1; //

        // Act
        Project project = repository.getProjectById(testProjectId);

        // Assert
        assertNotNull(project);
        assertEquals(testProjectId, project.getId());
        assertEquals("projekt 1", project.getName());
    }

    @Test
    void getAllProjects() {
        // Arrange
        int userId = 1;

        // Act
        ArrayList<Project> projects = repository.getAllProjects(userId);

        // Assert
        assertNotNull(projects);
        assertFalse(projects.isEmpty());

    }

   /* @Test
    void testUpdateProject() {
        // Arrange
        Project testProject = createTestProject(); // Create a test project

        // Act
        String newName = "Updated Test Project";
        testProject.setName(newName);
        projectRepository.updateProject(testProject);
        Project updatedProject = projectRepository.getProjectById(testProject.getId());

        // Assert
        assertNotNull(updatedProject);
        assertEquals(newName, updatedProject.getName());
        // Add additional assertions as needed
    }

    @Test
    void testDeleteProject() {
        // Arrange
        Project testProject = createTestProject();
        int projectId = testProject.getId();

        // Act
        projectRepository.deleteProject(projectId);
        Project deletedProject = projectRepository.getProjectById(projectId);

        // Assert
        assertNull(deletedProject);
    }

    */
}





