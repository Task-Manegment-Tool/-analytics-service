package com.blue.analytics_service.services;

import com.blue.analytics_service.exceptions.TaskIdNotFoundException;
import com.blue.analytics_service.models.TaskStatistic;
import com.blue.analytics_service.repositorys.TaskStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskStatisticService {
    @Autowired
    private TaskStatisticRepository taskStatisticRepository;
    public TaskStatistic getTaskCompletionStatistics(Integer taskId) {
        Optional<TaskStatistic> optionalTaskStatistic = Optional.ofNullable(taskStatisticRepository.findByTaskId(taskId));
        if (optionalTaskStatistic.isEmpty()) {
            throw new TaskIdNotFoundException("task with this task id not present");
        } else {
            return optionalTaskStatistic.get();
        }
    }
}
