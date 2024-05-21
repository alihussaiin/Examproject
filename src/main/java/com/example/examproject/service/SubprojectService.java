package com.example.examproject.service;

import com.example.examproject.model.Subproject;
import com.example.examproject.repository.SubprojectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubprojectService {
    private final SubprojectRepository subprojectRepository;

    public SubprojectService(SubprojectRepository subprojectRepository) {
        this.subprojectRepository = subprojectRepository;
    }

    public Subproject createSubproject(Subproject subproject) {
        return subprojectRepository.createSubproject(subproject);
    }

    public ArrayList<Subproject> getAllSubprojects(int projectId) {
        return subprojectRepository.getAllSubprojects(projectId);
    }

    public void updateSubproject(Subproject updateSubproject) {
        subprojectRepository.updateSubproject(updateSubproject);
    }

    public Subproject getSubprojectById(int id) {
        return subprojectRepository.getSubprojectById(id);
    }

    public void deleteSubproject(int id) {
        subprojectRepository.deleteSubproject(id);
    }
}
