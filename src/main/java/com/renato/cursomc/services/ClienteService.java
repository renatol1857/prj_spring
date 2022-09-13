package com.renato.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.cursomc.domain.Cliente;
import com.renato.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository; 

	public List<Cliente> saveAll(Iterable<Cliente> clientes){
		return clienteRepository.saveAll(clientes);
	}
	
}
