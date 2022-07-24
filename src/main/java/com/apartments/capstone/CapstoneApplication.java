package com.apartments.capstone;

import com.apartments.capstone.controller.AptController;
import com.apartments.capstone.dao.AptDaoImpl;
import com.apartments.capstone.serviceImpl.AptServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//tells spring boot to look in following packages
@ComponentScan(basePackageClasses = {AptController.class, AptServiceImpl.class, AptDaoImpl.class})
@EntityScan(basePackages = "entity")
public class CapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}

}
