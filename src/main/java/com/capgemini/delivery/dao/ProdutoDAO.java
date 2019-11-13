package com.capgemini.delivery.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.delivery.model.Batata;
import com.capgemini.delivery.model.Bebida;
import com.capgemini.delivery.model.Produto;
import com.capgemini.delivery.model.Tipo;

public class ProdutoDAO {

	List<Batata> batatas = new ArrayList<Batata>();
	List<Produto> adicionais = new ArrayList<Produto>();
	List<Produto> ingredientes = new ArrayList<Produto>();
	List<Bebida> refrigerantes = new ArrayList<Bebida>();
	List<Produto> produtos = new ArrayList<Produto>();
	List<Produto> produtosTipo = new ArrayList<Produto>();
	Produto produto = new Produto();

	public ProdutoDAO() {
		popularMassaDeTestes();
	}

	public List<Produto> buscarTodosAdicionais() {
		return adicionais;
	}

	public List<Batata> buscarTodasBatatas() {
		return batatas;
	}

	public List<Bebida> buscarTodasBebidas() {
		return refrigerantes;
	}

	public Batata buscarUmaBatata(int id) {
		for (Batata batata : batatas) {
			if (batata.getId() == id) {
				return batata;
			}
		}
		return null;
	}

	public List<Produto> buscarPorTipo(Tipo tipo) {
		for (Produto produto : buscarTodos()) {
			if (produto.getTipo() == tipo) {
				produtosTipo.add(produto);
			}
		}
		return produtosTipo;
	}

	public boolean excluirBatata(int id) {
		boolean encontrou = false;

		for (Batata batata : batatas) {
			if (batata.getId() == id) {
				batatas.remove(batata);
				encontrou = true;
				break;
			}
		}

		return encontrou;
	}

	public List<Produto> buscarTodos() {
		produtos.clear();
		produtos.addAll(buscarTodasBatatas());
		produtos.addAll(buscarTodosAdicionais());
		produtos.addAll(buscarTodasBebidas());

		return produtos;
	}

	public Produto atualizarProduto(int id, Produto produto) {
		for (int contador = 0; contador < produtos.size(); contador++) {
			if (produtos.get(contador).getId() == id) {
				produtos.set(contador, produto);
				break;
			}
		}

		return produto;
	}

	public Produto inserirProduto(Produto produto) {
		produtos.add(produto);
		produto.setId(789);
		return produto;
	}

	void popularMassaDeTestes() {
		// POPULANDO LISTA DE ADICIONAIS
		Produto adicional1 = new Produto();
		adicional1.setTitulo("Bacon");
		adicional1.setTipo(Tipo.ADICIONAL);

		Produto adicional2 = new Produto();
		adicional2.setTitulo("Ervilha");
		adicional2.setTipo(Tipo.ADICIONAL);

		Produto adicional3 = new Produto();
		adicional3.setTitulo("Cheddar");
		adicional3.setTipo(Tipo.ADICIONAL);

		adicionais.add(adicional1);
		adicionais.add(adicional2);
		adicionais.add(adicional3);

		// POPULANDO LISTA DE INGREDIENTES
		Produto ingrediente1 = new Produto();
		ingrediente1.setTitulo("Milho");

		Produto ingrediente2 = new Produto();
		adicional2.setTitulo("Ervilha");

		Produto ingrediente3 = new Produto();
		adicional3.setTitulo("Molho");

		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);
		ingredientes.add(ingrediente3);

		// POPULANDO A LISTA REFRIGERANTES
		Bebida bebida1 = new Bebida();
		Bebida bebida2 = new Bebida();
		Bebida bebida3 = new Bebida();

		bebida1.setTitulo("Fanta");
		bebida1.setPreco(5.00);
		bebida1.setTipo(Tipo.BEBIDA);

		bebida2.setTitulo("Coca-Cola");
		bebida2.setPreco(8.00);
		bebida2.setTipo(Tipo.BEBIDA);

		bebida3.setTitulo("Suco de laranja");
		bebida3.setPreco(3.00);
		bebida3.setTipo(Tipo.BEBIDA);

		refrigerantes.add(bebida1);
		refrigerantes.add(bebida2);
		refrigerantes.add(bebida3);

		// POPULANDO LISTA DE BATATAS
		Batata batata1 = new Batata();
		batata1.setTitulo("Batata1");
		batata1.setAdicionais(adicionais);
		batata1.setIngredientes(ingredientes);
		batata1.setPreco(10.50);
		batata1.setId(123);

		Batata batata2 = new Batata();
		batata2.setTitulo("Batata2");
		batata2.setAdicionais(adicionais);
		batata2.setIngredientes(ingredientes);
		batata2.setPreco(15.50);
		batata2.setId(456);

		batatas.add(batata1);
		batatas.add(batata2);

	}
}
