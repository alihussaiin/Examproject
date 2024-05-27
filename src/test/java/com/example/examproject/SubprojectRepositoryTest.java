package com.example.examproject;

import com.example.examproject.model.Subproject;
import com.example.examproject.repository.SubprojectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class SubprojectRepositoryTest {

    @Autowired
    private SubprojectRepository repository;

    @Test
    void getSubprojectById() {
        // Arrange
        int testSubprojectId = 1; //

        // Act
        Subproject subproject = repository.getSubprojectById(testSubprojectId);

        // Assert
        assertNotNull(subproject);
        assertEquals(testSubprojectId, subproject.getId());
        assertEquals("Subproject 1", subproject.getName());
    }
}

