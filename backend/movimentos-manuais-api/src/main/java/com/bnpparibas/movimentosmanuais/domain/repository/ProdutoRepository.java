package com.bnpparibas.movimentosmanuais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpparibas.movimentosmanuais.domain.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String>{

	Produto findByCodigoProduto(String codigoProduto);

}
