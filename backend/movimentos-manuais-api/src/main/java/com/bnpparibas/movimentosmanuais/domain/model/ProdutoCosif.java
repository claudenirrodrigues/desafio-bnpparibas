package com.bnpparibas.movimentosmanuais.domain.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="PRODUTO_COSIF")
public class ProdutoCosif implements Serializable{

	private static final long serialVersionUID = -7188109801773526001L;

	public static final String PRODUTO_PROPERTY = "produto";
	
	@Id
	@Column(name = "COD_COSIF")
	@NotNull(message = "Código COSIF é obrigatório")
	private String codigoCosif;
	
	@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumn(name="COD_PRODUTO")
	private Produto produto;
	
	@Column(name = "COD_CLASSIFICACAO")
	private String codigoClassificacao;
	
	@Column(name = "STA_STATUS")
	private String status;
	
	@OneToMany(mappedBy = MovimentoManual.PRODUTO_COSIF_PROPERTY, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<MovimentoManual> movimentosManuais;

	public String getCodigoCosif() {
		return codigoCosif;
	}

	public void setCodigoCosif(String codigoCosif) {
		this.codigoCosif = codigoCosif;
	}

	@JsonIgnore
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

	@JsonIgnore
	public List<MovimentoManual> getMovimentosManuais() {
		return movimentosManuais;
	}

	public void setMovimentosManuais(List<MovimentoManual> movimentoManualList) {
		this.movimentosManuais = movimentoManualList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoClassificacao, codigoCosif, movimentosManuais, produto, status);
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
				&& Objects.equals(codigoCosif, other.codigoCosif)
				&& Objects.equals(movimentosManuais, other.movimentosManuais)
				&& Objects.equals(produto, other.produto) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "ProdutoCosif [codigoCosif=" + codigoCosif + ", produto=" + produto + ", codigoClassificacao="
				+ codigoClassificacao + ", status=" + status + ", movimentosManuais=" + movimentosManuais + "]";
	}
	
}
