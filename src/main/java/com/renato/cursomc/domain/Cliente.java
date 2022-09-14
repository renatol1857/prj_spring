package com.renato.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.renato.cursomc.domain.enums.TipoCliente;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include()
	private Integer id;
	private String nome;
	private String email;
	private String cpfCnpj;

	// private TipoCliente tipo;
	private Integer tipo;

	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "Telefone")
	private Set<String> telefones = new HashSet<>();

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();

	public Cliente(String nome, String email, String cpfCnpj, TipoCliente tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipo = tipo.getCod();
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(this.tipo);
	}

	public void getTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

}
