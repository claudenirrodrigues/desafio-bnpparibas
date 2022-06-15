package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;
import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual.MovimentoManualId;

public interface MovimentoManualService {

	
	public MovimentoManual save(MovimentoManual movimentoManual);
	public void delete(MovimentoManualId movimentoManualId);
	public Optional<MovimentoManual> findById(MovimentoManualId movimentoManualId);
	public boolean existsById(@Valid MovimentoManualId movimentoManualId);
	public List<MovimentoManual> findAll();
	public List<MovimentoManual> findByAnyMovimentoManualId(Long numeroLancamento, Integer mes, Integer ano,
			String codigoProduto, String codigoCosif);
}
