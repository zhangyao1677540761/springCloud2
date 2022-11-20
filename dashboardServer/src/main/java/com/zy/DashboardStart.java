package com.zy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @学习小结
 */
@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
public class DashboardStart{

    public static void main(String[] args) {
        SpringApplication.run(DashboardStart.class, args);
    }



}