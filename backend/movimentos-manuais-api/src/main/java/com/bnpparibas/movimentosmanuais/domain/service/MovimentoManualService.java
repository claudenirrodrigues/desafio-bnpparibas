package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;

public interface MovimentoManualService {

	
	public MovimentoManual save(MovimentoManual movimentoManual);
	public void delete(Long numeroLancamento);
	public Optional<MovimentoManual> findByNumeroLancamento(Long numeroLancamento);
	public boolean existsByNumeroLancamento(@Valid Long numeroLancamento);
	public List<MovimentoManual> findAll();
}
