package com.orangeSoft.market.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.orangeSoft.market"})
@MapperScan("com.orangeSoft.market.mapper")
@EnableSwagger2
public class DemoApplication extends WebMvcConfigurationSupport {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
