package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import static by.of.bobrchess.belaruschess.server.util.Util.INCORRECT_COUNTRY_ABBREVIATION;
import static by.of.bobrchess.belaruschess.server.util.Util.INCORRECT_COUNTRY_ID;
import static by.of.bobrchess.belaruschess.server.util.Util.INCORRECT_COUNTRY_NAME;

@Entity
@Proxy(lazy = false)
@Table(name = "country")
public class Country {

    @Id
    @Min(value = 1, message = INCORRECT_COUNTRY_ID)
    @Column(name = "c_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Size(min = 3, max = 50, message = INCORRECT_COUNTRY_NAME)
    @Column(name = "c_name", nullable = false, length = 50, unique = true)
    private String name;

    @Size(min = 3, max = 3, message = INCORRECT_COUNTRY_ABBREVIATION)
    @Column(name = "c_abbreviation", nullable = false, length = 3, unique = true)
    private String abbreviation;

    public Country() {
    }

    public Country(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
