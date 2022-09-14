package com.renato.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.renato.cursomc.domain.enums.EstatoPgtoEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED )
public abstract class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include()
	private Integer id;
	
	private Integer estadoPgto;
	
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;

	public Pagamento(EstatoPgtoEnum estadoPgto, Pedido pedido) {
		super();
		this.estadoPgto = estadoPgto.getCod();
		this.pedido = pedido;
	}

	public void setEstadoPgto(EstatoPgtoEnum estado) {
		this.estadoPgto = estado.getCod();
	}

	public EstatoPgtoEnum getEstadoPgto() {
		return EstatoPgtoEnum.toEnum(estadoPgto);
	}
	
}
