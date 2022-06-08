package com.bnpparibas.movimentosmanuais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;


@Repository
public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, Long>{
	
	@Query("select max(m.numeroLancamento) from MovimentoManual m where m.mes = ?1 and m.ano =?2")
	Long findTopNumeroLancamentoByMesAndAno(Integer mes, Integer ano);

}
