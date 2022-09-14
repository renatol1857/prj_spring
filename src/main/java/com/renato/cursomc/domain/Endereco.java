package com.renato.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include()
	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;

	@JsonBackReference
	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Cidade cidade;

	public Endereco(String logradouro, String numero, String complemento, String bairro, String cep, Cidade cidade,
			Cliente cliente) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.cliente = cliente;
	}

}
