package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpparibas.movimentosmanuais.domain.exception.DomainException;
import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;
import com.bnpparibas.movimentosmanuais.domain.repository.MovimentoManualRepository;



@Service
public class MovimentoManualServiceImpl implements MovimentoManualService{

	@Autowired
	private MovimentoManualRepository movimentoManualRepository;

	@Override
	public MovimentoManual save(MovimentoManual movimentoManual) {
		Long novoNumeroLancamento = movimentoManualRepository
				.findTopNumeroLancamentoByMesAndAno(movimentoManual.getMes(), movimentoManual.getAno());
		movimentoManual.setNumeroLancamento(novoNumeroLancamento + 1);
		return movimentoManualRepository.save(movimentoManual);
	}
	
	
	@Override
	public void delete(Long id) {
		throw new DomainException("Funcionalidade não implementada!");
	}


	@Override
	public Optional<MovimentoManual> findByNumeroLancamento(Long id) {
		return movimentoManualRepository.findById(id);
	}


	@Override
	public boolean existsByNumeroLancamento(@Valid Long id) {
		return movimentoManualRepository.existsById(id);
	}


	@Override
	public List<MovimentoManual> findAll() {
		return movimentoManualRepository.findAll();
	}
}
