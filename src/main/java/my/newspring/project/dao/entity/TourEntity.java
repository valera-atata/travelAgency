package my.newspring.project.dao.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tours", schema = "", catalog = "relationship")
public class TourEntity {
    private Long tourId;
    private String organizer;
    private Date date;
    private String type;
    private Integer cost;
    
    private RouteEntity route;
    
    private Set<ContractEntity> contracts = new HashSet<ContractEntity>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id", nullable = false, insertable = true, updatable = true)
    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    @Basic
    @Column(name = "organizer", nullable = true, insertable = true, updatable = true, length = 200)
    public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	@Basic
    @Column(name = "date", nullable = true, insertable = true, updatable = true, length = 200)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Basic
    @Column(name = "type", nullable = true, insertable = true, updatable = true, length = 200)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Basic
    @Column(name = "cost", nullable = true, insertable = true, updatable = true)
	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinColumn(name = "route_id")
	public RouteEntity getRoute(){
		return route;
	}
	
	public void setRoute(RouteEntity route){
		this.route = route;
	}
	
	@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
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
