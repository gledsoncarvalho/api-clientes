package br.unit.api.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.unit.api.entity.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {
	
	@Query("select cc.saldo from ContaCorrente cc where cc.numero = :numero")
	BigDecimal findSaldoByNumero(@Param("numero") Integer numero);

	@Query("select cc from ContaCorrente cc where cc.numero = :numero")
	ContaCorrente findByNumero(@Param("numero") Integer numero);
}
