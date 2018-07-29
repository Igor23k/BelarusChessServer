package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.ALL;

@Entity
@Proxy(lazy = false)
@Table(name = "place")
public class Place {

    @Id
    @Min(1)
    @Column(name = "pl_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Size(min = 1, max = 100)
    @Column(name = "pl_name", nullable = false, length = 100)
    private String name;

    @Size(min = 3, max = 50)
    @Column(name = "pl_city", nullable = false, length = 50)
    private String city;

    @Size(min = 3, max = 50)
    @Column(name = "pl_street", nullable = false, length = 50)
    private String street;

    @Size(min = 1, max = 10)
    @Column(name = "pl_building", nullable = false, length = 10)
    private String building;

    @Size(min = 1, max = 100)
    @Column(name = "pl_capacity", nullable = false)
    private Integer capacity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = ALL)
    @JoinColumn(name = "pl_country_id", nullable = false)
    private Country country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Place(String name, String city, String street, String building, Integer capacity, Country country) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.building = building;
        this.capacity = capacity;
        this.country = country;
    }

    public Place() {
    }
}
