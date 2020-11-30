package br.unit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unit.api.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
