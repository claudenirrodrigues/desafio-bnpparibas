package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpparibas.movimentosmanuais.domain.exception.DomainException;
import com.bnpparibas.movimentosmanuais.domain.model.ProdutoCosif;
import com.bnpparibas.movimentosmanuais.domain.repository.ProdutoCosifRepository;

@Service
public class ProdutoCosifServiceImpl implements ProdutoCosifService{
	
	@Autowired
	private ProdutoCosifRepository produtoCosifRepository;
	
	@Override
	public List<ProdutoCosif> listarTodos () {
		List<ProdutoCosif> produtoCosifs = produtoCosifRepository.findAll();
		
		if(produtoCosifs == null || produtoCosifs.isEmpty()) {
			throw new DomainException("Não há Produto COSIF cadastrado.");
		}
		
		return produtoCosifs;
	
	}
	

}
