package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.sql.Date;

import static javax.persistence.CascadeType.ALL;

@Entity
@Proxy(lazy = false)
@Table(name = "tournament")
public class Tournament {

    @Id
    @Min(1)
    @Column(name = "tr_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Size(min = 8, max = 50)
    @Column(name = "tr_name", nullable = false, length = 50)
    private String name;

    @Size(min = 20, max = 100)
    @Column(name = "tr_short_description", nullable = false, length = 100)
    private String shortDescription;

    @Size(min = 100, max = 20000)
    @Column(name = "tr_full_description", nullable = false, length = 20000)
    private String fullDescription;

    @Column(name = "tr_start", nullable = true)
    private Date startDate;

    @Column(name = "tr_finish", nullable = true)
    private Date finishDate;

    @Size(max = 1)
    @Column(name = "tr_count_players_in_team", nullable = false)
    private Integer countPlayersInTeam;

    @ManyToOne(fetch = FetchType.EAGER, cascade = ALL)
    @JoinColumn(name = "tr_place_id", nullable = true)
    private Place place;

    @ManyToOne(fetch = FetchType.EAGER, cascade = ALL)
    @JoinColumn(name = "tr_referee_id", nullable = true)
    private User referee;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getCountPlayersInTeam() {
        return countPlayersInTeam;
    }

    public void setCountPlayersInTeam(Integer countPlayersInTeam) {
        this.countPlayersInTeam = countPlayersInTeam;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public User getReferee() {
        return referee;
    }

    public void setReferee(User referee) {
        this.referee = referee;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Tournament(String name, String shortDescription, String fullDescription, Date startDate, Date finishDate, Integer countPlayersInTeam, Place place, User referee) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.countPlayersInTeam = countPlayersInTeam;
        this.place = place;
        this.referee = referee;
    }

    public Tournament() {
    }
}
