package com.bnpparibas.movimentosmanuais.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MOVIMENTO_MANUAL")
public class MovimentoManual implements Serializable{

	private static final long serialVersionUID = -6780929154790333356L;

	public static final String PRODUTO_COSIF_PROPERTY = "produtoCosif";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NUM_LANCAMENTO")
	@NotNull
	private Long numeroLancamento;
	
	@Column(name="DAT_MES")
	@NotNull
	private Integer mes;
	
	@Column(name="DAT_ANO")
	@NotNull
	private Integer ano;
	
	@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
	@JoinColumns({
        @JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO"),
        @JoinColumn(name = "COD_COSIF", referencedColumnName = "COD_COSIF") })
	private ProdutoCosif produtoCosif;

		
	@Column(name = "DES_DESCRICAO")
	private String descricao;
	
	@Column(name = "DAT_MOVIMENTO")
	private Date dataMovimento;
	
	@Column(name = "COD_USUARIO")
	private String codigoUsuario;
	
	@Column(name = "VAL_VALOR")
	private Double valor;

	public Long getNumeroLancamento() {
		return numeroLancamento;
	}

	public void setNumeroLancamento(Long numeroLancamento) {
		this.numeroLancamento = numeroLancamento;
	}

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

	public ProdutoCosif getProdutoCosif() {
		return produtoCosif;
	}

	public void setProdutoCosif(ProdutoCosif produtoCosif) {
		this.produtoCosif = produtoCosif;
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
		return Objects.hash(ano, codigoUsuario, dataMovimento, descricao, mes, numeroLancamento, produtoCosif, valor);
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
				&& Objects.equals(produtoCosif, other.produtoCosif) && Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "MovimentoManual [numeroLancamento=" + numeroLancamento + ", mes=" + mes + ", ano=" + ano
				+ ", produtoCosif=" + produtoCosif + ", descricao=" + descricao + ", dataMovimento=" + dataMovimento
				+ ", codigoUsuario=" + codigoUsuario + ", valor=" + valor + "]";
	}
	
	
}
