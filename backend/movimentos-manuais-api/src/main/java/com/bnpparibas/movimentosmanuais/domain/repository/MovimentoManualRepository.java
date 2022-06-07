package com.bnpparibas.movimentosmanuais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;


@Repository
public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, Long>{

}
