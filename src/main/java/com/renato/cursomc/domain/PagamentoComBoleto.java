package com.renato.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.renato.cursomc.domain.enums.EstatoPgtoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Date dataVcto;
	private Date dataPgto;

	public PagamentoComBoleto(EstatoPgtoEnum estadoPgto, Pedido pedido, Date dataVcto, Date dataPgto) {
		super(estadoPgto, pedido);
		this.dataVcto = dataVcto;
		this.dataPgto = dataPgto;
		
	}

}
