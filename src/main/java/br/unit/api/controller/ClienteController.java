package br.unit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unit.api.entity.Cliente;
import br.unit.api.repository.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="API REST Cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@ApiOperation(value="Cadastra cliente")
	@PostMapping("/cliente")
	public ResponseEntity<Object> cadastrarCliente(Cliente cliente) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO CADASTRAR CLIENTE");
		}	
	}
	
	@ApiOperation(value="Retorna todos os clientes cadastrados")
	@GetMapping("/cliente/todos")
	public ResponseEntity<Object> obterClientes() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO AO OBTER CLIENTES");
		}
	}
	
}
