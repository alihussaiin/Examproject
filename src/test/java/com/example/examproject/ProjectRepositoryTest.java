package com.example.examproject;

import com.example.examproject.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProjectRepositoryTest {

    //Act
    @Test
    void createProject() {
        Project project = new Project(1, 1,"hej", Local.date.now(),'16-05-2024');


    }


    //Arrange

    //Assert





}
