package com.renato.cursomc.domain.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {
	PESSOA_FISICA(1,"Pessoa Fisica"),
	PESSOA_JURIDICA(2,"Pessoa Juridica");

	private Integer cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null)
			throw new IllegalArgumentException("Id TipoCliente invalido!");
		
		for (TipoCliente x : TipoCliente.values()) {
			if ( x.getCod().equals(cod))
				return x;
		}
		throw new IllegalArgumentException("Id TipoCliente invalido!");
	}
}
