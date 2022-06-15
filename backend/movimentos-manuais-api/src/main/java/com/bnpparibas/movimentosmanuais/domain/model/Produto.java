package com.bnpparibas.movimentosmanuais.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Entity
@Table(name="PRODUTO")
@Data
public class Produto implements Serializable{
	
	private static final long serialVersionUID = -8175854214604256518L;

	@Id
	@Column(name = "COD_PRODUTO")
	@NotNull(message = "Código do Produto é obrigatório")
	private String codigoProduto;
	
	@Column(name = "DES_PRODUTO")
	private String descricacaoProduto;
	
	@Column(name = "STA_STATUS")
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = ProdutoCosif.PRODUTO_PROPERTY, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProdutoCosif> produtosCosif;

		
}
