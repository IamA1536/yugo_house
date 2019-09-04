package org.csu.sfteam.house_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"org.csu.sfteam.house.biz.mapper"})
@ComponentScan(basePackages = {"org.csu.sfteam.house_web.controller","org.csu.sfteam.house.biz.service"})
public class HouseWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseWebApplication.class, args);
    }

}
