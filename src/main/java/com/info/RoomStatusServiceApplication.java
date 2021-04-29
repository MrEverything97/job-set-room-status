package com.info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.info.mapper")
public class RoomStatusServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoomStatusServiceApplication.class, args);
    }

}
