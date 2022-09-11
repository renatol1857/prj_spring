package com.renato.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.cursomc.domain.Categoria;
import com.renato.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Optional<Categoria> buscarPor(Integer id) {
		return categoriaRepository.findById(id);
	}

	public Categoria salvar(Categoria cat) {
		return categoriaRepository.save(cat);
	}

	public List<Categoria> salvarAll(Iterable<Categoria> lstCat) {
		return categoriaRepository.saveAll(lstCat);
	}

	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	
	
	
}
