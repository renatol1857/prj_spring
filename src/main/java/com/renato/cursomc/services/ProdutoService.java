package com.renato.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.cursomc.domain.Produto;
import com.renato.cursomc.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> saveAll(Iterable<Produto> produtos) {
		return produtoRepository.saveAll(produtos);
	}
	
}
