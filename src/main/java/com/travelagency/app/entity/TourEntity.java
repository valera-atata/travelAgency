package com.travelagency.app.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
//@Table(name = "tours", schema = "", catalog = "relationship")
@Table(name = "tours")
public class TourEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tour_id")
    private Long tourId;
	
	@Column(name = "organizer", nullable = false, insertable = true, updatable = true, length = 200)
    private String organizer;
	
	@Column(name = "date", nullable = false, insertable = true, updatable = true)
    private Date date;
	
	@Column(name = "type", nullable = false, insertable = true, updatable = true, length = 200)
    private String type;
    
    @Column(name = "cost", nullable = false, insertable = true, updatable = true)
    private Integer cost;
    
    @ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private RouteEntity route;
    
    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private Set<ContractEntity> contracts = new HashSet<ContractEntity>();
    
    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
    
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public RouteEntity getRoute(){
		return route;
	}
	
	public void setRoute(RouteEntity route){
		this.route = route;
	}
	
    public Set<ContractEntity> getContracts() {
        return this.contracts;
    }

    public void setContracts(Set<ContractEntity> contracts) {
        this.contracts = contracts;
    }

    public void addContract(ContractEntity contract) {
    	contract.setTour(this);
    	getContracts().add(contract);
    }

    public void removeContract(ContractEntity contract) {
    	getContracts().remove(contract);
    }
	
}
