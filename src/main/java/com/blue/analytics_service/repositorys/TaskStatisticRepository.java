package com.blue.analytics_service.repositorys;

import com.blue.analytics_service.models.TaskStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatisticRepository extends JpaRepository<TaskStatistic, Integer> {
    TaskStatistic findByTaskId(Integer taskId);
}
