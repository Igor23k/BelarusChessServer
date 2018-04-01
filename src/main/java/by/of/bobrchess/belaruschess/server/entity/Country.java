package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity

@Table(name = "remind")
public class Country {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "c_name", nullable = false, length = 50)
    private String name;

    @Column(name = "c_abbreviation", nullable = false, length = 3)
    private String abbreviation;

    public Country() {
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
