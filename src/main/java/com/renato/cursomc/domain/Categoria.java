package com.renato.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.renato.cursomc.repositories.CategoriaRepository;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include()
	private Integer id;
	private String nome;

	@JsonManagedReference
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	


}
