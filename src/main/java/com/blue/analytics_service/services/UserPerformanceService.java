package com.blue.analytics_service.services;

import com.blue.analytics_service.exceptions.UserIdNotFoundException;
import com.blue.analytics_service.models.UserPerformance;
import com.blue.analytics_service.repositorys.UserPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPerformanceService {
    @Autowired
    private UserPerformanceRepository userPerformanceRepository;
    public UserPerformance getUserPerformanceData(Integer userId) {
        Optional<UserPerformance> optionalUserPerformance = Optional.ofNullable(userPerformanceRepository.findByUserId(userId));
        if (optionalUserPerformance.isEmpty()) {
            throw new UserIdNotFoundException("user with this user id not present");
        } else {
            return optionalUserPerformance.get();
        }
    }
}
