package com.codemao.xunmiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.codemao.xunmiao.mapper")
public class XunmiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XunmiaoApplication.class, args);
    }

}
