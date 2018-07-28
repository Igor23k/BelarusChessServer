package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Proxy(lazy = false)
@Table(name = "user")
public class User {

    @Id
    @Column(name = "u_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "u_name", nullable = false, length = 100)
    private String name;

    @Column(name = "u_surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "u_patronymic", nullable = false, length = 100)
    private String patronymic;

    @Column(name = "u_birthday", nullable = false)
    private LocalDateTime birthday;

    @Column(name = "u_status", length = 50)
    private String status;

    @Column(name = "u_email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "u_password", nullable = false, length = 45)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = ALL)
    @JoinColumn(name = "u_rank_id")
    private Rank rank;

    @ManyToOne(fetch = FetchType.EAGER, cascade = ALL)
    @JoinColumn(name = "u_country_id")
    private Country country;

    @Column(name = "u_rating")
    private Integer rating;

    @OneToMany(cascade = ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_place", joinColumns = {
            @JoinColumn(name = "u_id", referencedColumnName = "u_id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "pl_id", referencedColumnName = "pl_id")
                    })
    private List<Place> places;

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = ALL)
    @JoinColumn(name = "u_coach_id", referencedColumnName = "u_id")
    private User coach;

    public User(String name, String surname, String patronymic, LocalDateTime birthday, String email, String status, String password, Rank rank, Country country, List<Place> places) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.email = email;
        this.status = status;
        this.password = password;
        this.rank = rank;
        this.country = country;
        this.places = places;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getCoach() {
        return coach;
    }

    public void setCoach(User coach) {
        this.coach = coach;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
