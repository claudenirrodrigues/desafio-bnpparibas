package com.bnpparibas.movimentosmanuais.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpparibas.movimentosmanuais.domain.model.MovimentoManual;
import com.bnpparibas.movimentosmanuais.domain.repository.MovimentoManualRepository;



@Service
public class MovimentoManualService {

	@Autowired
	private MovimentoManualRepository movimentoManualRepository;

	public MovimentoManual salvar(MovimentoManual movimentoManual) {
		return movimentoManualRepository.save(movimentoManual);
	}
	
	public void excluir(Long id) {
		
	}

	public void excluir(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
