package com.bnpparibas.movimentosmanuais.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name="PRODUTO_COSIF")
@Data
public class ProdutoCosif implements Serializable{

	private static final long serialVersionUID = -7188109801773526001L;

	public static final String PRODUTO_PROPERTY = "id.produto";
	
	@EmbeddedId
	private ProdutoCosifId id;
	
	@Column(name = "COD_CLASSIFICACAO")
	private String codigoClassificacao;
	
	@Column(name = "STA_STATUS")
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy = MovimentoManual.PRODUTO_COSIF_PROPERTY, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<MovimentoManual> movimentosManuais;
	
	@Embeddable
	@Access(AccessType.FIELD)
	@Data
	public static class ProdutoCosifId implements Serializable{
		
		private static final long serialVersionUID = 7888277129480111336L;

		@Column(name = "COD_COSIF")
		@NotNull(message = "Código COSIF é obrigatório")
		private String codigoCosif;
		
		@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
		@JoinColumn(name="COD_PRODUTO")
		private Produto produto;
	}


		
}
