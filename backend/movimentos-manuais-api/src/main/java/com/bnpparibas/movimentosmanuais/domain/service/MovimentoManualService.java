package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.Optional;

import javax.validation.Valid;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;

public interface MovimentoManualService {

	
	public MovimentoManual salvar(MovimentoManual movimentoManual);
	public void excluir(Integer id);
	public Optional<MovimentoManual> findById(Integer id);
	public boolean existsById(@Valid Integer id);
}
