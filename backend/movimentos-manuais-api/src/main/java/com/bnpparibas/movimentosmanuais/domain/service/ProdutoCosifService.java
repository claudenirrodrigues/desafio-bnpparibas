package com.bnpparibas.movimentosmanuais.domain.service;

import java.util.List;

import com.bnpparibas.movimentosmanuais.domain.model.Produto;
import com.bnpparibas.movimentosmanuais.domain.model.ProdutoCosif;

public interface ProdutoCosifService {
	
	public List<ProdutoCosif> findAll ();

	public List<ProdutoCosif> findByProduto(Produto produto);

	

}
