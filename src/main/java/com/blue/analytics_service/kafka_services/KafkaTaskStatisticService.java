package com.blue.analytics_service.kafka_services;

import com.blue.analytics_service.models.TaskStatistic;
import com.blue.analytics_service.repositorys.TaskStatisticRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaTaskStatisticService {
    @Autowired
    private TaskStatisticRepository taskStatisticRepository;
    private final ObjectMapper objectMapper;
    public KafkaTaskStatisticService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @KafkaListener(topics = "task_statistic_topic", groupId = "analytics_group")
    public void consumeTaskStatistic(ConsumerRecord<String, String> record) {
        TaskStatistic taskStatistic = parseTaskStatistic(record.value());
        taskStatisticRepository.save(taskStatistic);
    }

    private TaskStatistic parseTaskStatistic(String value) {
        try {
            return objectMapper.readValue(value, TaskStatistic.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse TaskStatistic", e);

        }
    }
}
