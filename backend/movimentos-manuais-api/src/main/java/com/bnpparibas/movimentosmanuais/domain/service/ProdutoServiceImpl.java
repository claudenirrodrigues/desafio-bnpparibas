package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpparibas.movimentosmanuais.domain.exception.DomainException;
import com.bnpparibas.movimentosmanuais.domain.model.Produto;
import com.bnpparibas.movimentosmanuais.domain.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public Produto findByCodigoProduto (Produto produto) {
		Produto produtoExistente = produtoRepository.findByCodigoProduto(produto.getCodigoProduto());
		
		if(produtoExistente == null) {
			throw new DomainException("Produto não encontrado para o código informado.");
		}
		
		return produtoExistente;
	
	}

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	

}
