package com.capgemini.delivery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.delivery.model.Produto;
import com.capgemini.delivery.model.Tipo;
import com.capgemini.delivery.repository.ClienteRepository;
import com.capgemini.delivery.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Produto> buscarTodosProdutos() {
		Iterable<Produto> produtos = produtoRepository.findAll();

		return produtos;
	}

	@RequestMapping(value = "/batatas", method = RequestMethod.GET)
	@ResponseBody
	public List<Produto> buscarTodasBatatas() {
		List<Produto> batatas = produtoRepository.findByTipo(Tipo.BATATA);
		return batatas;
	}

	@RequestMapping(value = "/bebidas", method = RequestMethod.GET)
	@ResponseBody
	public List<Produto> buscarTodosBebidas() {
		List<Produto> bebidas = produtoRepository.findByTipo(Tipo.BEBIDA);
		return bebidas;
	}

	@RequestMapping(value = "/tipo/{tipo}", method = RequestMethod.GET)
	@ResponseBody
	public List<Produto> buscarPorTipo(@PathVariable Tipo tipo) {
		List<Produto> adicionais = produtoRepository.findByTipo(tipo);
		return adicionais;
	}
	
	@RequestMapping(value = "/adicionais", method = RequestMethod.GET)
	@ResponseBody
	public List<Produto> buscarTodosAdicionais() {
		List<Produto> adicionais = produtoRepository.findByTipo(Tipo.ADICIONAL);
		return adicionais;
	}

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Produto> buscarUmProduto(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto;
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	void excluirProduto(@PathVariable Long id) {
		try {
			produtoRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println("Houve um erro !");
		}
	}

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	@ResponseBody
	public Produto inserirProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}