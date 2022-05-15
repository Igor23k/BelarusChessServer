package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

import static by.of.bobrchess.belaruschess.server.util.Constants.*;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;

@Entity
@Proxy(lazy = false)
@Table(name = "user")
public class User {

    @Id
    @Min(value = 1)
    @Column(name = "u_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Size(min = 2, max = 30, message = INCORRECT_USER_NAME)
    @Column(name = "u_name", nullable = false, length = 30)
    private String name;

    @Size(min = 2, max = 30, message = INCORRECT_USER_SURNAME)
    @Column(name = "u_surname", nullable = false, length = 30)
    private String surname;

    @Size(min = 2, max = 30, message = INCORRECT_USER_PATRONYMIC)
    @Column(name = "u_patronymic", nullable = false, length = 30)
    private String patronymic;

    @Column(name = "u_birthday", nullable = false)
    private String birthday;

    @Size(min = 1, max = 250, message = INCORRECT_USER_EMAIL)
    @Column(name = "u_email", nullable = false, unique = true, length = 250)
    private String email;

    @Size(min = 32, max = 32, message = INCORRECT_USER_PASSWORD)
    @Column(name = "u_password", nullable = false, length = 32)
    private String password;

    @Column(name = "u_is_male", nullable = false)
    private Boolean beMale;

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = MERGE)
    @JoinColumn(name = "u_rank_id", referencedColumnName = "r_id")
    private Rank rank;

    @ManyToOne(fetch = FetchType.EAGER, cascade = MERGE)
    @JoinColumn(name = "u_country_id", nullable = false)
    private Country country;

    @Min(value = 1, message = INCORRECT_USER_RATING_SMALL)
    @Max(value = 5000, message = INCORRECT_USER_RATING_BIG)
    @Column(name = "u_rating")
    private Integer rating;

    @Size(min = 3, max = 61, message = INCORRECT_USER_COACH)
    @Column(name = "u_coach", nullable = true, length = 61)
    private String coach;

/*    @OneToMany(cascade = MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_place", joinColumns = {
            @JoinColumn(name = "u_id", referencedColumnName = "u_id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "pl_id", referencedColumnName = "pl_id")
                    })
    private List<Place> places;*/

    @OneToMany(cascade = ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "u_role", referencedColumnName = "u_id")
    private List<UserRole> roles;

    @Lob
    @Column(name = "u_image", columnDefinition = "MEDIUMBLOB", nullable = true)
    private Byte[] image;

    public User(String name, String surname, String patronymic, String birthday, String email, String password,
                Rank rank, Country country, List<UserRole> roles, Byte[] image) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.rank = rank;
        this.country = country;
        this.roles = roles;
        this.image = image;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Boolean getBeMale() {
        return beMale;
    }

    public void setBeMale(Boolean beMale) {
        this.beMale = beMale;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
