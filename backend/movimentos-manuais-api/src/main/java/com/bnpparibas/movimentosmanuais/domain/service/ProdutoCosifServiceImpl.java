package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpparibas.movimentosmanuais.domain.exception.DomainException;
import com.bnpparibas.movimentosmanuais.domain.model.Produto;
import com.bnpparibas.movimentosmanuais.domain.model.ProdutoCosif;
import com.bnpparibas.movimentosmanuais.domain.repository.ProdutoCosifRepository;

@Service
public class ProdutoCosifServiceImpl implements ProdutoCosifService{
	
	@Autowired
	private ProdutoCosifRepository produtoCosifRepository;
	
	@Override
	public List<ProdutoCosif> findAll () {
		List<ProdutoCosif> produtoCosifs = produtoCosifRepository.findAll();
		
		if(produtoCosifs == null || produtoCosifs.isEmpty()) {
			throw new DomainException("Não há Produto COSIF cadastrado.");
		}
		
		return produtoCosifs;
	
	}

	@Override
	public List<ProdutoCosif> findByProdutoCosifIdProduto(Produto produto) {
		
		if(produto == null || produto.getCodigoProduto() == null) {
			throw new DomainException("Código do produto é obrigatório para efetuar a consulta Cosif.");
		}
		
		List<ProdutoCosif> produtoCosifs = produtoCosifRepository.findByIdProduto(produto);
		
		if(produtoCosifs == null || produtoCosifs.isEmpty()) {
			throw new DomainException("Não há Produto COSIF cadastrado.");
		}
		
		return produtoCosifs;
	}
	
	
	

}
