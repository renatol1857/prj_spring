package com.renato.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renato.cursomc.domain.Categoria;
import com.renato.cursomc.domain.Cidade;
import com.renato.cursomc.domain.Cliente;
import com.renato.cursomc.domain.Endereco;
import com.renato.cursomc.domain.Estado;
import com.renato.cursomc.domain.Produto;
import com.renato.cursomc.domain.enums.TipoCliente;
import com.renato.cursomc.services.CategoriaService;
import com.renato.cursomc.services.CidadeService;
import com.renato.cursomc.services.ClienteService;
import com.renato.cursomc.services.EnderecoService;
import com.renato.cursomc.services.EstadoService;
import com.renato.cursomc.services.ProdutoService;

@SpringBootApplication
@RestController
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EnderecoService enderecoService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	/*
	 * http://localhost:8080/hello?name=Renato
	 * http://localhost:8080/hello
	 */
		
	@GetMapping(path = "/hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@Override
	public void run(String... args) throws Exception {		
		Categoria cat1 = new Categoria("Informatica");
		Categoria cat2 = new Categoria("Escritorio");
		
		Produto p1 = new Produto("Computador",2000.00);
		Produto p2 = new Produto("Impresora",800.00);
		Produto p3 = new Produto("Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaService.salvarAll(Arrays.asList(cat1,cat2));
		produtoService.saveAll(Arrays.asList(p1,p2,p3));

		
		Estado est1 = new Estado("Sao Paulo");
		Estado est2 = new Estado("Minas Gerais");
		
		Cidade cidade1 = new Cidade("Sao Paulo", est1);
		Cidade cidade2 = new Cidade("Uberlandia", est2);
		Cidade cidade3 = new Cidade("Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(cidade1,cidade3));
		est2.getCidades().addAll(Arrays.asList(cidade2));
		
		estadoService.saveAll(Arrays.asList(est1,est2));
		cidadeService.saveAll(Arrays.asList(cidade1,cidade2, cidade3));
		
		Cliente cliente1 = new Cliente("Maria Silva", "maria@gmail.com","10020030088", TipoCliente.PESSOA_FISICA);
		cliente1.getTelefones().addAll(Arrays.asList("111111111","2222222222"));

		Endereco end1 = new Endereco("Rua flores","300","apto 23", "Jardim", "04267001", cidade1, cliente1 );
		Endereco end2 = new Endereco("Avenidas Matos","105","Sala 800", "Centro", "04267002", cidade2, cliente1 );
		
		cliente1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		clienteService.saveAll(Arrays.asList(cliente1));
		enderecoService.saveAll(Arrays.asList(end1,end2));
		
	}

}
