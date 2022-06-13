package com.bnpparibas.movimentosmanuais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpparibas.movimentosmanuais.domain.model.Produto;
import com.bnpparibas.movimentosmanuais.domain.model.ProdutoCosif;

@Repository
public interface ProdutoCosifRepository extends JpaRepository<ProdutoCosif, String>{

	List<ProdutoCosif> findByProduto(Produto produto);

}
