package com.bnpparibas.movimentosmanuais.domain.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;
import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual.MovimentoManualId;


@Repository
public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, MovimentoManualId>{
	
	@Query("select max(m.id.numeroLancamento) from MovimentoManual m " +
				"where m.id.mes = ?1 and m.id.ano =?2")
	Long findTopNumeroLancamentoByMesAndAno(Integer mes, Integer ano);
	
	Optional<MovimentoManual> findByIdNumeroLancamento(Long numeroLancamento); 


}
