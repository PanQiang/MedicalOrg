package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.mapper")
public class MedicalOrgApplication {

	public static void main(String[] args) {

		SpringApplication.run(MedicalOrgApplication.class, args);
	}
}
