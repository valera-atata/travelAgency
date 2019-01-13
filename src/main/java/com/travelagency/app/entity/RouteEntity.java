package com.travelagency.app.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "routes")
public class RouteEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private Long routeId;
	
	@Column(name = "route", nullable = false, insertable = true, updatable = true, length = 400)
    private String route;
	
    @Column(name = "country", nullable = false, insertable = true, updatable = true, length = 200)
    private String country;
    
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private Set<TourEntity> tours = new HashSet<TourEntity>();
    
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<TourEntity> getTours() {
        return this.tours;
    }

    public void setTours(Set<TourEntity> tours) {
        this.tours = tours;
    }

    public void addTour(TourEntity tour) {
    	tour.setRoute(this);
    	getTours().add(tour);
    }

    public void removeTour(TourEntity tour) {
    	getTours().remove(tour);
    }
    
}
