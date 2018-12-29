package my.newspring.project.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "routes", schema = "", catalog = "relationship")
public class RouteEntity {
    private Long routeId;
    private String route;
    private String country;
    
    private Set<TourEntity> tours = new HashSet<TourEntity>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id", nullable = false, insertable = true, updatable = true)
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "route", nullable = true, insertable = true, updatable = true, length = 400)
    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Basic
    @Column(name = "country", nullable = true, insertable = true, updatable = true, length = 200)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
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
