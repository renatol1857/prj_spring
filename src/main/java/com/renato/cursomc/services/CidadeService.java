package com.renato.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.cursomc.domain.Cidade;
import com.renato.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> saveAll(Iterable<Cidade> cidades){
		return cidadeRepository.saveAll(cidades);
	}
}
