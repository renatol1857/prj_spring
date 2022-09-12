package com.renato.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.cursomc.domain.Categoria;
import com.renato.cursomc.repositories.CategoriaRepository;
import com.renato.cursomc.services.execption.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscarPor(Integer id) {
		/*
		 * return categoriaRepository.findById(id);
		 */
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				String.format("Categoria nao encontrada ID %d Tipo %s", id, Categoria.class.getName())));

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
