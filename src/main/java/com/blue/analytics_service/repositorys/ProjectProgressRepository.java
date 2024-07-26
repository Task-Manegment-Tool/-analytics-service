package com.blue.analytics_service.repositorys;

import com.blue.analytics_service.models.ProjectProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectProgressRepository extends JpaRepository<ProjectProgress, Integer> {
    ProjectProgress findByProjectId(Integer projectId);
}
