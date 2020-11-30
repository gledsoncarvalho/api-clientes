package br.unit.api.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	private @Id @GeneratedValue Integer id;
	private String nome;
	private String endereco;
	private String email;
	private Date dataDeCadastro;
	
	public Cliente() { }

	public Cliente(Integer id, String nome, String endereco, String email, Date dataDeCadastro) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.dataDeCadastro = dataDeCadastro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	
	
	
	
	
	

}
