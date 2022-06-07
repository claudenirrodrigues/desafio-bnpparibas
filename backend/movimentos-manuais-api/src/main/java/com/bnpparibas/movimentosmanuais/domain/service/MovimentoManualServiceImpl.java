package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;
import com.bnpparibas.movimentosmanuais.domain.repository.MovimentoManualRepository;



@Service
public class MovimentoManualServiceImpl implements MovimentoManualService{

	@Autowired
	private MovimentoManualRepository movimentoManualRepository;

	@Override
	public MovimentoManual salvar(MovimentoManual movimentoManual) {
		return movimentoManualRepository.save(movimentoManual);
	}
	
	
	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
	}


	@Override
	public Optional<MovimentoManual> findById(Long id) {
		return movimentoManualRepository.findById(id);
	}


	@Override
	public boolean existsById(@Valid Long id) {
		return movimentoManualRepository.existsById(id);
	}
}
