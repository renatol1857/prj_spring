package com.renato.cursomc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CursomcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	/*
	 * http://localhost:8080/hello?name=Renato
	 * http://localhost:8080/hello
	 */
		
	@GetMapping(path = "/hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}
