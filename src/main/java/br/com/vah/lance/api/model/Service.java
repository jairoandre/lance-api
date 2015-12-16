package br.com.vah.lance.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LANCA_SERVICO")
public class Service implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "seqServiceGenerator", sequenceName = "SEQ_TB_LANCA_SERVICO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqServiceGenerator")
	@Column(name="ID_SERVICO")
	private Long id;
	@Column(name="CD_HISTORICO_PADRAO")
	private Integer defaultHistory;
	@Column(name="CD_TP_DOCUMENTO")
	private Integer documentType;
	@Column(name="CD_CONTA_CONTABIL")
	private Integer ledgerAccount;
	@Column(name="CD_CONTA_RESULTADO")
	private Integer resultAccount;
	@Column(name="CD_CONTA_CUSTO")
	private Integer costAccount;
	@Column(name="DESCRICAO")
	private String title;
	@ManyToOne
	@JoinColumn(name="ID_TP_SERVICO", nullable=false)
	private ServiceType serviceType;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDefaultHistory() {
		return defaultHistory;
	}
	public void setDefaultHistory(Integer defaultHistory) {
		this.defaultHistory = defaultHistory;
	}
	public Integer getDocumentType() {
		return documentType;
	}
	public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}
	public Integer getLedgerAccount() {
		return ledgerAccount;
	}
	public void setLedgerAccount(Integer ledgerAccount) {
		this.ledgerAccount = ledgerAccount;
	}
	public Integer getResultAccount() {
		return resultAccount;
	}
	public void setResultAccount(Integer resultAccount) {
		this.resultAccount = resultAccount;
	}
	public Integer getCostAccount() {
		return costAccount;
	}
	public void setCostAccount(Integer costAccount) {
		this.costAccount = costAccount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ServiceType getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}	
}
