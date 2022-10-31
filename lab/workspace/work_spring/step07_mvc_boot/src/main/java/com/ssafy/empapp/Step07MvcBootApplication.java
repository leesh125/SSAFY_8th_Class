package com.ssafy.empapp;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ssafy.empapp.model.dao", annotationClass = Mapper.class)
@SpringBootApplication
public class Step07MvcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step07MvcBootApplication.class, args);
	}

}
