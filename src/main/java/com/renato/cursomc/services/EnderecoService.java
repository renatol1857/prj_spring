package com.renato.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.cursomc.domain.Endereco;
import com.renato.cursomc.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> saveAll(Iterable<Endereco> enderecos){
		return enderecoRepository.saveAll(enderecos);
	}
}
