package com.example.examproject;

import com.example.examproject.model.Subproject;
import com.example.examproject.repository.SubprojectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class SubprojectRepositoryTest {

    @Autowired
    private SubprojectRepository subprojectRepository;
    private Subproject subproject;
   /* @BeforeEach
    public void setUp() {
        subproject = new Subproject();
        subproject.setProjectId(1);
        subproject.setName("Test subprojekt");
        subproject.setDescription("Oprettet for at teste");
        subproject.setStatus("Påbegyndt");
        subproject.setStartDate(LocalDate.now());
        subproject.setEndDate(LocalDate.now().plusDays(10));
    }
    @Test
    public void testCreateSubproject() {
        Subproject createdSubproject = subprojectRepository.createSubproject(subproject);
        assertNotNull(createdSubproject);
        assertNotNull(createdSubproject.getId());
        assertEquals("Test subprojekt", createdSubproject.getName());
    }

    @Test
    public void testGetAllSubprojects() {
        subprojectRepository.createSubproject(subproject);
        List<Subproject> subprojects = subprojectRepository.getAllSubprojects(1);
        assertNotNull(subprojects);
        assertFalse(subprojects.isEmpty());
    }

    @Test
    public void testUpdateSubproject() {
        Subproject createdSubproject = subprojectRepository.createSubproject(subproject);
        createdSubproject.setName("Updateret subprojekt navn");
        Subproject updatedSubproject = subprojectRepository.updateSubproject(createdSubproject);
        assertEquals("Updateret subprojekt navn", updatedSubproject.getName());
    }

    @Test
    public void testDeleteSubproject() {
        Subproject createdSubproject = subprojectRepository.createSubproject(subproject);
        int subprojectId = createdSubproject.getId();
        subprojectRepository.deleteSubproject(subprojectId);
        Subproject deletedSubproject = subprojectRepository.getSubprojectById(subprojectId);
        assertNull(deletedSubproject);
    }*/
}