package com.renato.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renato.cursomc.domain.Categoria;
import com.renato.cursomc.services.CategoriaService;

@SpringBootApplication
@RestController
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaService categoriaService;
	
	

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

	@Override
	public void run(String... args) throws Exception {		
		Categoria cat1 = new Categoria("Informatica");
		Categoria cat2 = new Categoria("Escritorio");
		
		categoriaService.salvarAll(Arrays.asList(cat1,cat2));
		
	}

}
