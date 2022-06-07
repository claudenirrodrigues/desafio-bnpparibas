package com.bnpparibas.movimentosmanuais.domain.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PRODUTO_COSIF")
public class ProdutoCosif implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PRODUTO_PROPERTY = "produto";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_COSIF")
	private String codigoCosif;
	
	@ManyToOne
	@JoinColumn(name = "COD_PRODUTO", nullable = false)
    private Produto produto;
	
	@Column(name = "COD_CLASSIFICACAO")
	private String codigoClassificacao;
	
	@Column(name = "STA_STATUS")
	private String status;

	public String getCodigoCosif() {
		return codigoCosif;
	}

	public void setCodigoCosif(String codigoCosif) {
		this.codigoCosif = codigoCosif;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getCodigoClassificacao() {
		return codigoClassificacao;
	}

	public void setCodigoClassificacao(String codigoClassificacao) {
		this.codigoClassificacao = codigoClassificacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoClassificacao, codigoCosif, produto, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoCosif other = (ProdutoCosif) obj;
		return Objects.equals(codigoClassificacao, other.codigoClassificacao)
				&& Objects.equals(codigoCosif, other.codigoCosif) && Objects.equals(produto, other.produto)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "ProdutoCosif [codigoCosif=" + codigoCosif + ", produto=" + produto + ", codigoClassificacao="
				+ codigoClassificacao + ", status=" + status + "]";
	}

	
}
