package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public void excluir(Integer id) {
		// TODO Auto-generated method stub
	}


	@Override
	public Optional<MovimentoManual> findById(Integer id) {
		return movimentoManualRepository.findById(id);
	}


	@Override
	public boolean existsById(@Valid Integer id) {
		return movimentoManualRepository.existsById(id);
	}
}
