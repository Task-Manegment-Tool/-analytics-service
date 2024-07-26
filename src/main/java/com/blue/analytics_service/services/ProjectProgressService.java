package com.blue.analytics_service.services;

import com.blue.analytics_service.exceptions.ProjectIdNotFoundException;
import com.blue.analytics_service.models.ProjectProgress;
import com.blue.analytics_service.repositorys.ProjectProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectProgressService {
    @Autowired
    private ProjectProgressRepository projectProgressRepository;
    public ProjectProgress getProjectProgressData(Integer projectId) {
        Optional<ProjectProgress> optionalProjectProgress = Optional.ofNullable(projectProgressRepository.findByProjectId(projectId));
        if (optionalProjectProgress.isEmpty()) {
            throw new ProjectIdNotFoundException("project with this project id not available");
        } else {
            return optionalProjectProgress.get();
        }
    }
}
