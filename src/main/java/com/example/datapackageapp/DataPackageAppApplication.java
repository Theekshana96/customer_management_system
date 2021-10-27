package com.example.datapackageapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication

public class DataPackageAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(DataPackageAppApplication.class, args);

	}
	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}


}
