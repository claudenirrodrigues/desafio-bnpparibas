package com.bnpparibas.movimentosmanuais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpparibas.movimentosmanuais.domain.model.Produto;
import com.bnpparibas.movimentosmanuais.domain.model.ProdutoCosif;
import com.bnpparibas.movimentosmanuais.domain.model.ProdutoCosif.ProdutoCosifId;

@Repository
public interface ProdutoCosifRepository extends JpaRepository<ProdutoCosif, ProdutoCosifId>{

	List<ProdutoCosif> findByIdProduto(Produto produto);

}
