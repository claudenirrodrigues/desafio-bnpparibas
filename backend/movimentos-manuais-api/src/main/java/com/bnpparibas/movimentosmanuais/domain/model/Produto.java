package com.bnpparibas.movimentosmanuais.domain.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="PRODUTO")
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
	
	@OneToMany(mappedBy = ProdutoCosif.PRODUTO_PROPERTY, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProdutoCosif> produtosCosif;

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricacaoProduto() {
		return descricacaoProduto;
	}

	public void setDescricacaoProduto(String descricacaoProduto) {
		this.descricacaoProduto = descricacaoProduto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@JsonIgnore
	public List<ProdutoCosif> getProdutosCosif() {
		return produtosCosif;
	}

	public void setProdutosCosif(List<ProdutoCosif> produtos) {
		this.produtosCosif = produtos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoProduto, descricacaoProduto, produtosCosif, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigoProduto, other.codigoProduto)
				&& Objects.equals(descricacaoProduto, other.descricacaoProduto)
				&& Objects.equals(produtosCosif, other.produtosCosif) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Produto [codigoProduto=" + codigoProduto + ", descricacaoProduto=" + descricacaoProduto + ", status="
				+ status + ", produtosCosif=" + produtosCosif + "]";
	}

	
}
