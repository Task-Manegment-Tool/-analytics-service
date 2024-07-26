package com.blue.analytics_service.controllers;

import com.blue.analytics_service.models.ProjectProgress;
import com.blue.analytics_service.models.TaskStatistic;
import com.blue.analytics_service.models.UserPerformance;
import com.blue.analytics_service.services.ProjectProgressService;
import com.blue.analytics_service.services.TaskStatisticService;
import com.blue.analytics_service.services.UserPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
    @Autowired
    private TaskStatisticService taskStatisticService;
    @Autowired
    private UserPerformanceService userPerformanceService;
    @Autowired
    private ProjectProgressService projectProgressService;


    @GetMapping("/task-completion/{taskId}")
    public ResponseEntity<TaskStatistic> getTaskCompletionStatistics(@PathVariable("taskId") Integer taskId) {
        TaskStatistic taskStatistic = taskStatisticService.getTaskCompletionStatistics(taskId);
        return new ResponseEntity<>(taskStatistic, HttpStatus.OK);
    }

    @GetMapping("/user-performance/{userId}")
    public ResponseEntity<UserPerformance> getUserPerformanceData(@PathVariable("userId") Integer userId) {
        UserPerformance userPerformance = userPerformanceService.getUserPerformanceData(userId);
        return new ResponseEntity<>(userPerformance, HttpStatus.OK);
    }

    @GetMapping("/project-progress/{projectId}")
    public ResponseEntity<ProjectProgress> getProjectProgressData(@PathVariable("projectId") Integer projectId) {
        ProjectProgress projectProgress = projectProgressService.getProjectProgressData(projectId);
        return new ResponseEntity<>(projectProgress, HttpStatus.OK);
    }

}
