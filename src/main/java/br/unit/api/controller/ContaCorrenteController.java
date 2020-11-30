package br.unit.api.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unit.api.entity.ContaCorrente;
import br.unit.api.repository.ContaCorrenteRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/contaCorrente")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	@ApiOperation(value = "Cadastra nova conta")
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrar(@RequestBody ContaCorrente contaCorrente) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(contaCorrenteRepository.save(contaCorrente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL CADASTRAR CONTA");
		}
	}
	
	@ApiOperation(value = "Retorna o saldo da conta")
	@GetMapping("/saldo/{numero}")
	public ResponseEntity<Object> obterSaldo(@PathVariable("numero") Integer numero) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(contaCorrenteRepository.findSaldoByNumero(numero));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL OBTER SALDO");
		}
	}

	@ApiOperation(value = "Efetuar saque em conta corrente")
	@PutMapping("/sacar/{numero}")
	public ResponseEntity<Object> efetuarSaque(@PathVariable("numero") Integer numero, @RequestBody BigDecimal valor) {
		try {
			ContaCorrente contaCorrente = contaCorrenteRepository.findByNumero(numero);
			BigDecimal novoSaldo = contaCorrente.getSaldo().subtract(valor);
			if (novoSaldo.compareTo(BigDecimal.ZERO) >= 0) {
				contaCorrente.setSaldo(novoSaldo);
				contaCorrenteRepository.save(contaCorrente);
			} else {
				throw new Exception("SALDO INSUFICIENTE");
			}
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@ApiOperation(value = "Efetuar depósito em conta corrente")
	@PutMapping("/depositar/{numero}")
	public ResponseEntity<Object> efetuarDeposito(@PathVariable("numero") Integer numero,
			@RequestBody BigDecimal valor) {
		try {
			ContaCorrente contaCorrente = contaCorrenteRepository.findByNumero(numero);
			contaCorrente.setSaldo(contaCorrente.getSaldo().add(valor));
			contaCorrenteRepository.save(contaCorrente);
			return ResponseEntity.status(HttpStatus.OK).body("DEPÓSITO EFETUADO COM SUCESSO");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NÃO FOI POSSÍVEL EFETUAR DEPÓSITO");
		}
	}

}
