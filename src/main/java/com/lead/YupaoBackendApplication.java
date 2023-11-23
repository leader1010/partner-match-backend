package com.lead;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lead.mapper")
@ServletComponentScan
//@ComponentScan(basePackages = {"com.lead.mapper"}) # 使用@Autowired时需要告诉springboot扫描范围
public class YupaoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(YupaoBackendApplication.class, args);
    }

}
