package com.bnpparibas.movimentosmanuais.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;



@Entity
@Table(name="MOVIMENTO_MANUAL")
@Data
public class MovimentoManual implements Serializable{

	private static final long serialVersionUID = -6780929154790333356L;

	public static final String PRODUTO_COSIF_PROPERTY = "id.produtoCosif";
	
	@EmbeddedId
	private MovimentoManualId id;
	
	@Column(name = "DES_DESCRICAO")
	@NotNull(message = "Descrição é obrigatório")
	private String descricao;
	
	@Column(name = "DAT_MOVIMENTO")
	@NotNull(message = "Data do Movimento é obrigatório")
	private Date dataMovimento;
	
	@Column(name = "COD_USUARIO")
	@NotNull(message = "Código do Usuário é obrigatório")
	private String codigoUsuario;
	
	@Column(name = "VAL_VALOR")
	@NotNull(message = "Valor é obrigatório")
	private double valor;
	
	@Embeddable
	@Access(AccessType.FIELD)
	@Data
	public static class MovimentoManualId implements Serializable{

		private static final long serialVersionUID = -5164854928212218220L;
		
		@Column(name="NUM_LANCAMENTO")
		private Long numeroLancamento;
		
		@Column(name="DAT_MES")
		@NotNull(message = "Mês é obrigatório")
		private Integer mes;
		
		@Column(name="DAT_ANO")
		@NotNull(message = "Ano é obrigatório")
		private Integer ano;
		
		@ManyToOne()
		@JoinColumns({
	        @JoinColumn(name = "COD_PRODUTO", referencedColumnName = "COD_PRODUTO"),
	        @JoinColumn(name = "COD_COSIF", referencedColumnName = "COD_COSIF") })
		private ProdutoCosif produtoCosif;
		
	}

}
