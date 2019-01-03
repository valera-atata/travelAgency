package com.travelagency.app.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
//@Table(name = "contracts", schema = "", catalog = "relationship")
@Table(name = "contracts")
public class ContractEntity {
    private Long contractId;
    private Date date;
    
    private AgentEntity agent;
    private ClientEntity client;
    private TourEntity tour;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id", nullable = false, insertable = true, updatable = true)
    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "date", nullable = true, insertable = true, updatable = true, length = 200)
    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name = "agent_id")
	public AgentEntity getAgent(){
		return agent;
	}
	
	public void setAgent(AgentEntity agent){
		this.agent = agent;
	}
	
	@ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id")
	public ClientEntity getClient(){
		return client;
	}
	
	public void setClient(ClientEntity client){
		this.client = client;
	}
	
	@ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name = "tour_id")
	public TourEntity getTour(){
		return tour;
	}
	
	public void setTour(TourEntity tour){
		this.tour = tour;
	}
}
