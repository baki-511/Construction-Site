package com.site.construction.service;

import com.site.construction.entity.Project;
import com.site.construction.exception.ProjectNotFoundException;
import com.site.construction.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    
    public Project addProject(Project project, MultipartFile file) {
        String image = "";
        try {
            image = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        project.setImage(image);
        return projectRepository.save(project);
    }
    
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    
    public Project getProjectById(Integer projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
    }
    
    public String deleteProject(Integer projectId) {
        Project project = getProjectById(projectId);
        projectRepository.delete(project);
        return "Project Deleted Successfully!";
    }
    
    public Project updateProject(Project project, MultipartFile file) {
        Project projectById = getProjectById(project.getProjectId());
        if (file.isEmpty()) {
            project.setImage(projectById.getImage());
        } else {
            String image = "";
            try {
                image = Base64.getEncoder().encodeToString(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            project.setImage(image);
        }
        return projectRepository.save(project);
    }
}
