package com.renato.cursomc.domain.enums;

import lombok.Getter;

@Getter
public enum EstatoPgtoEnum {
	PENDENTE(1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	
	private Integer cod;
	private String descricao;
	
	private EstatoPgtoEnum(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static EstatoPgtoEnum toEnum(Integer cod) {
		if (cod == null)
			throw new IllegalArgumentException();
		for (EstatoPgtoEnum x : EstatoPgtoEnum.values()) {
			if (cod.equals(x.getCod()))
				return x;
		}
		throw new IllegalArgumentException();
	}
		
}
