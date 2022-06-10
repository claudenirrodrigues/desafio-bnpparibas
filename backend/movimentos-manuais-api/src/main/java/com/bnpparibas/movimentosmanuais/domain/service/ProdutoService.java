package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.List;

import com.bnpparibas.movimentosmanuais.domain.model.Produto;

public interface ProdutoService {
	
	public Produto findByCodigoProduto (Produto produto);
	public List<Produto> findAll();

}
