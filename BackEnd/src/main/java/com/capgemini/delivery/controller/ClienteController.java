package com.capgemini.delivery.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.delivery.model.Cliente;
import com.capgemini.delivery.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Cliente> buscarTodosCliente() {
		Iterable<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Cliente> buscarUmCliente(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente;
	}

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	@ResponseBody
	public Cliente inserirCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void excluirCliente(@PathVariable Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (Exception e) {
			System.out.println("Houve um erro !");
		}
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
