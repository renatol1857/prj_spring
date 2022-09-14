package com.renato.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.cursomc.domain.Pagamento;
import com.renato.cursomc.repositories.PagamentoRepository;

@Service
public class PagamentoService {
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public List<Pagamento> saveAll(Iterable<Pagamento> pagamentos){
		return pagamentoRepository.saveAll(pagamentos);
	}
}
