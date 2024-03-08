package com.k8sone.k8sonedemoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class K8sonedemooneApplication {
	
	 private Logger LOGGER = LoggerFactory.getLogger(K8sonedemooneApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(K8sonedemooneApplication.class, args);
	}


	@GetMapping("/greet/{name}") 
    public String geBookById(@PathVariable String name) { 
		String greet = "Hello, "+name+"!!";
		LOGGER.info("greet -  {}", greet);
        return greet; 
    } 
}
