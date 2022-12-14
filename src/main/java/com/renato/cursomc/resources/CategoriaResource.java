package com.renato.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renato.cursomc.domain.Categoria;
import com.renato.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		return categoriaService.listar(); 
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscarPor(@PathVariable("id") Integer id) {
		Categoria obj = categoriaService.buscarPor(id);
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}

}
