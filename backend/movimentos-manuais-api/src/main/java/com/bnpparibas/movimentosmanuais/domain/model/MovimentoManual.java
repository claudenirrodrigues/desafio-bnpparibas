package com.bnpparibas.movimentosmanuais.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MOVIMENTO_MANUAL")
public class MovimentoManual implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "DAT_MES")
	@NotNull
	private Integer mes;
	
	@Column(name = "DAT_ANO")
	@NotNull
	private Integer ano;
	
	@Column(name = "NUM_LANCAMENTO")
	@NotNull
	private Long numeroLancamento;
	
	@OneToMany(mappedBy = "produto")
	private List<ProdutoCosif> produtos;
	
	@Column(name = "DES_DESCRICAO")
	private String descricao;
	
	@Column(name = "DAT_MOVIMENTO")
	private Date dataMovimento;
	
	@Column(name = "COD_USUARIO")
	private String codigoUsuario;
	
	@Column(name = "VAL_VALOR")
	private Double valor;

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Long getNumeroLancamento() {
		return numeroLancamento;
	}

	public void setNumeroLancamento(Long numeroLancamento) {
		this.numeroLancamento = numeroLancamento;
	}

	public List<ProdutoCosif> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoCosif> produtos) {
		this.produtos = produtos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, codigoUsuario, dataMovimento, descricao, mes, numeroLancamento, produtos, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentoManual other = (MovimentoManual) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(codigoUsuario, other.codigoUsuario)
				&& Objects.equals(dataMovimento, other.dataMovimento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(mes, other.mes) && Objects.equals(numeroLancamento, other.numeroLancamento)
				&& Objects.equals(produtos, other.produtos) && Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "MovimentoManual [mes=" + mes + ", ano=" + ano + ", numeroLancamento=" + numeroLancamento + ", produtos="
				+ produtos + ", descricao=" + descricao + ", dataMovimento=" + dataMovimento + ", codigoUsuario="
				+ codigoUsuario + ", valor=" + valor + "]";
	}
	
	
	
}
