package com.zhiquan.cai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("com.zhiquan.*")  //包扫描
@EnableWebMvc
@SpringBootApplication
public class SbootmabatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootmabatisApplication.class, args);
    }

}
