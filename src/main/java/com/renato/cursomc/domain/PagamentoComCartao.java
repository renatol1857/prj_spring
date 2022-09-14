package com.renato.cursomc.domain;

import javax.persistence.Entity;

import com.renato.cursomc.domain.enums.EstatoPgtoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcelar;

	public PagamentoComCartao(EstatoPgtoEnum estadoPgto, Pedido pedido,Integer numeroParcelar) {
		super(estadoPgto, pedido);
		this.numeroParcelar = numeroParcelar;
	}
	
	

}
