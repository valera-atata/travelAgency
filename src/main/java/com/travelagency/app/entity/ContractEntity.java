package com.travelagency.app.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "contracts")
public class ContractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contract_id", nullable = false, insertable = true, updatable = true)
    private Long contractId;
	
	@Column(name = "date", nullable = false, insertable = true, updatable = true, length = 200)
    private Date date;
    
	@ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private AgentEntity agent;
	
	@ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;
	
	@ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private TourEntity tour;
    
   
    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public AgentEntity getAgent(){
		return agent;
	}
	
	public void setAgent(AgentEntity agent){
		this.agent = agent;
	}
	
	public ClientEntity getClient(){
		return client;
	}
	
	public void setClient(ClientEntity client){
		this.client = client;
	}
	
	public TourEntity getTour(){
		return tour;
	}
	
	public void setTour(TourEntity tour){
		this.tour = tour;
	}
}
