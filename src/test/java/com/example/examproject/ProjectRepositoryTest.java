package com.example.examproject;

import com.example.examproject.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("h2")
public class ProjectRepositoryTest {

    //Act
    @Test
    void createProject() {
        var project = new Project(1, 1,"hej", '15-05-2024','16-05-2024');


    }


    //Arrange

    //Assert





}
