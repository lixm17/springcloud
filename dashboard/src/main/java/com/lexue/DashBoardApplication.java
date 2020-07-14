package com.lexue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by 25610 on 2020/7/14.
 *
 * Dashboadr界面
 http://localhost:9990/hystrix
 然后在界面中输入需要监控的端点url：
 http://localhost:8083/actuator/hystrix.stream
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(DashBoardApplication.class,args);
    }
}
