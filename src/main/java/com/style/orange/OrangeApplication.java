package com.style.orange;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author Mr.Li
 */
@SpringBootApplication
@MapperScan({"com.style.orange.dao"})
@EnableElasticsearchRepositories(basePackages = "com.style.orange.elasticsearch")
public class OrangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeApplication.class, args);
    }
}
