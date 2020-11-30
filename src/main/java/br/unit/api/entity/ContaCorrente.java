package br.unit.api.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContaCorrente {

	private @Id @GeneratedValue Integer id;
	private String titular;
	private Integer numero;
	private BigDecimal saldo;
	
	public ContaCorrente() { }

	public ContaCorrente(Integer id, String titular, Integer numero, BigDecimal saldo) {
		super();
		this.id = id;
		this.titular = titular;
		this.numero = numero;
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	

}
