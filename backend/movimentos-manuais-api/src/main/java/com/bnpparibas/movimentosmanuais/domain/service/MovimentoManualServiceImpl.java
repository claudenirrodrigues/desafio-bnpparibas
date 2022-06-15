package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpparibas.movimentosmanuais.domain.exception.DomainException;
import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;
import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual.MovimentoManualId;
import com.bnpparibas.movimentosmanuais.domain.repository.MovimentoManualRepository;



@Service
public class MovimentoManualServiceImpl implements MovimentoManualService{

	@Autowired
	private MovimentoManualRepository movimentoManualRepository;
	
	@Override
	public MovimentoManual save(MovimentoManual movimentoManual) {
		Long numeroLancamentoAtual = movimentoManualRepository
				.findTopNumeroLancamentoByMesAndAno(movimentoManual.getId().getMes(), 
						movimentoManual.getId().getAno());
		
		movimentoManual.getId()
							.setNumeroLancamento(numeroLancamentoAtual == null ? 1 : ++numeroLancamentoAtual);
		return movimentoManualRepository.save(movimentoManual);
	}
	
	
	@Override
	public void delete(MovimentoManualId id) {
		throw new DomainException("Funcionalidade não implementada!");
	}


	@Override
	public Optional<MovimentoManual> findById(MovimentoManualId id) {
		return movimentoManualRepository.findById(id);
	}


	@Override
	public boolean existsById(@Valid MovimentoManualId id) {
		return movimentoManualRepository.existsById(id);
	}


	@Override
	public List<MovimentoManual> findAll() {
		return movimentoManualRepository.findAll();
	}


	@Override
	public List<MovimentoManual> findByAnyMovimentoManualId(Long numeroLancamento, Integer mes, Integer ano,
			String codigoProduto, String codigoCosif) {
		
		
		return null;
	}

}
