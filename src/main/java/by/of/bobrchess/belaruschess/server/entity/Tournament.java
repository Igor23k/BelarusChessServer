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
@Table(name = "tournament")
public class Tournament {

    @Id
    @Min(value = 1, message = INCORRECT_TOURNAMENT_ID)
    @Column(name = "tr_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Size(min = 8, max = 50, message = INCORRECT_TOURNAMENT_NAME)
    @Column(name = "tr_name", nullable = false, length = 50)
    private String name;

    @Size(min = 10, max = 100, message = INCORRECT_TOURNAMENT_SHORT_DESCRIPTION)//todo bug поменять на 20 потом
    @Column(name = "tr_short_description", nullable = false, length = 100)
    private String shortDescription;

    @Size(min = 10, max = 2000, message = INCORRECT_TOURNAMENT_FULL_DESCRIPTION)//todo bug поменять на 100 потом
    @Column(name = "tr_full_description", nullable = false, length = 2000)
    private String fullDescription;

    @Column(name = "tr_start", nullable = false)
    private String startDate;

    @Column(name = "tr_finish", nullable = false)
    private String finishDate;

    @Max(value = 30, message = INCORRECT_TOURNAMENT_COUNT_PLAYERS_IN_TEAM)
    @Column(name = "tr_count_players_in_team", nullable = false)
    private Integer countPlayersInTeam;

    @ManyToOne(fetch = FetchType.EAGER, cascade = MERGE)
    @JoinColumn(name = "tr_place_id", nullable = false)
    private Place place;

    @ManyToOne(fetch = FetchType.EAGER, cascade = MERGE)
    @JoinColumn(name = "tr_referee_id", nullable = false)
    private User referee;

    @Column(name = "tr_image", nullable = true)
    private String image;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Tournament(@Size(min = 8, max = 50) String name, @Size(min = 20, max = 100) String shortDescription, @Size(min = 10, max = 100) String fullDescription, String startDate, String finishDate, @Max(30) Integer countPlayersInTeam, Place place, User referee, String image) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.countPlayersInTeam = countPlayersInTeam;
        this.place = place;
        this.referee = referee;
        this.image = image;
    }

    public Tournament() {
    }
}
