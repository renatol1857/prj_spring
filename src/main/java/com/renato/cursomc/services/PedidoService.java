package com.renato.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.cursomc.domain.Pedido;
import com.renato.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> saveAll(Iterable<Pedido> estados){
		return pedidoRepository.saveAll(estados);
	}
}
