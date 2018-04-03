package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Proxy(lazy = false)
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "r_name", nullable = false, length = 100)
    private String name;

    @Column(name = "r_surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "r_patronymic", nullable = false, length = 100)
    private String patronymic;

    @Column(name = "r_birthdate", nullable = false)//check type
    private Date birthdate;

    @Column(name = "p_email", nullable = false, length = 100)
    private String email;

    @Column(name = "p_password", nullable = false, length = 45)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "r_rank_id", nullable = false)
    private Rank rank;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "pl_country_id", nullable = false)
    private Country country;

    public Person(String name, String surname, String patronymic, Date birthdate, String email, String password, Rank rank, Country country) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.rank = rank;
        this.country = country;
    }

    public Person() {
    }
}
