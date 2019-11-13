package com.capgemini.delivery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.capgemini.delivery.dao.ProdutoDAO;
import com.capgemini.delivery.model.Batata;
import com.capgemini.delivery.model.Bebida;
import com.capgemini.delivery.model.Produto;
import com.capgemini.delivery.model.Tipo;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	private static ProdutoDAO dao = new ProdutoDAO();

	@RequestMapping(value = "/batatas", method = RequestMethod.GET)
	@ResponseBody
	public List<Batata> buscarTodasBatatas() {
		List<Batata> batatas = dao.buscarTodasBatatas();
		return batatas;
	}

	@RequestMapping(value = "/adicionais", method = RequestMethod.GET)
	@ResponseBody
	public List<Produto> buscarTodosAdicionais() {
		List<Produto> adicionais = dao.buscarTodosAdicionais();
		return adicionais;
	}

	@RequestMapping(value = "/bebidas", method = RequestMethod.GET)
	@ResponseBody
	public List<Bebida> buscarTodasBebidas() {
		List<Bebida> bebidas = dao.buscarTodasBebidas();
		return bebidas;
	}

	@RequestMapping(value = "/batatas/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Batata buscarUmaBatata(@PathVariable int id) {
		Batata batata = dao.buscarUmaBatata(id);

		return batata;
	}

	@RequestMapping(value = "/tipo/{tipo}", method = RequestMethod.GET)
	@ResponseBody
	public List<Produto> buscarPorTipo(@PathVariable Tipo tipo) {
		List<Produto> produtoPorTipo = dao.buscarPorTipo(tipo);

		return produtoPorTipo;
	}

	@RequestMapping(value = "/excluirBatata/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String excluiBatata(@PathVariable int id) {
		String retorno;

		if (dao.excluirBatata(id)) {
			retorno = "Batata com o id: " + id + " excluida";
		} else {
			retorno = "Falha ao excluir";
		}
		return retorno;
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	@ResponseBody
    Produto atualizarProduto(@PathVariable int id,@RequestBody Produto produto) {
    	return dao.atualizarProduto(id, produto);
    }

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Produto> buscarTodosProdutos() {
		return dao.buscarTodos();
	}

	@RequestMapping(value = "inserir", method = RequestMethod.POST)
	@ResponseBody
    Produto inserirProduto(@RequestBody Produto produto) {
    	return dao.inserirProduto(produto);
    }
}