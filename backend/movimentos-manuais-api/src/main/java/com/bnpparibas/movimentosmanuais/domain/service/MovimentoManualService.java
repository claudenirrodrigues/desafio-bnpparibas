package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.Optional;

import javax.validation.Valid;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;

public interface MovimentoManualService {

	
	public MovimentoManual salvar(MovimentoManual movimentoManual);
	public void excluir(Long id);
	public Optional<MovimentoManual> findById(Long id);
	public boolean existsById(@Valid Long id);
}
