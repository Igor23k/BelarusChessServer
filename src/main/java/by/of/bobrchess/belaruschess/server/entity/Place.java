package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import static by.of.bobrchess.belaruschess.server.util.Constants.*;
import static javax.persistence.CascadeType.MERGE;

@Entity
@Proxy(lazy = false)
@Table(name = "place")
public class Place {

    @Id
    @Min(value = 1, message = INCORRECT_PLACE_ID)
    @Column(name = "pl_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Size(min = 1, max = 100, message = INCORRECT_PLACE_NAME)
    @Column(name = "pl_name", nullable = false, length = 100)
    private String name;

    @Size(min = 3, max = 50, message = INCORRECT_PLACE_CITY)
    @Column(name = "pl_city", nullable = false, length = 50)
    private String city;

    @Size(min = 3, max = 50, message = INCORRECT_PLACE_STREET)
    @Column(name = "pl_street", nullable = false, length = 50)
    private String street;

    @Size(min = 1, max = 10, message = INCORRECT_PLACE_BUILDING)
    @Column(name = "pl_building", nullable = false, length = 10)
    private String building;

    @Column(name = "pl_approved", nullable = false)
    private Boolean approved;

    @Min(value = 1, message = INCORRECT_PLACE_CAPACITY_SMALL)
    @Max(value = 10000, message = INCORRECT_PLACE_CAPACITY_BIG)
    @Column(name = "pl_capacity", nullable = false)
    private Integer capacity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = MERGE)
    @JoinColumn(name = "pl_country_id", nullable = false)
    private Country country;

    @Lob
    @Column(name = "pl_image", nullable = true)
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pl_created_by", nullable = false)
    private User createdBy;

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

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Place(String name, String city, String street, String building, Integer capacity, Country country, Boolean approved, String image, User createdBy) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.building = building;
        this.capacity = capacity;
        this.country = country;
        this.approved = approved;
        this.createdBy = createdBy;
        this.image = image;
    }

    public Place() {
    }
}
