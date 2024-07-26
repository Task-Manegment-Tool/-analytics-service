package com.blue.analytics_service.repositorys;

import com.blue.analytics_service.models.UserPerformance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPerformanceRepository extends JpaRepository<UserPerformance, Integer> {
    UserPerformance findByUserId(Integer userId);
}
