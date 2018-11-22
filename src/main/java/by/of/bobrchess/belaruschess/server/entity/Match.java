package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

import static by.of.bobrchess.belaruschess.server.util.Util.INCORRECT_COUNT_POINTS_OF_TEAM;
import static by.of.bobrchess.belaruschess.server.util.Util.INCORRECT_GAME_ID;
import static by.of.bobrchess.belaruschess.server.util.Util.INCORRECT_MATCH_ID;
import static javax.persistence.CascadeType.MERGE;

@Entity
@Proxy(lazy = false)
@Table(name = "match1")
public class Match {

    @Id
    @Min(value = 1, message = INCORRECT_MATCH_ID)
    @Column(name = "m_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Min(value = 0, message = INCORRECT_COUNT_POINTS_OF_TEAM)
    @Column(name = "m_count_points_first_team", nullable = false)
    private Double countPointsFirstTeam;

    @Min(value = 0, message = INCORRECT_COUNT_POINTS_OF_TEAM)
    @Column(name = "m_count_points_second_team", nullable = false)
    private Double countPointsSecondTeam;

    @Column(name = "m_date", nullable = false)
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = MERGE)
    @JoinColumn(name = "m_tournament_id")
    private Tournament tournament;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = MERGE)
    @JoinColumn(name = "m_first_team_id")
    private Team firstTeam;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = MERGE)
    @JoinColumn(name = "m_second_team_id")
    private Team secondTeam;

    public Match(Double countPointsFirstTeam, Double countPointsSecondTeam, LocalDateTime date, Tournament tournament, Team firstTeam, Team secondTeam) {
        this.countPointsFirstTeam = countPointsFirstTeam;
        this.countPointsSecondTeam = countPointsSecondTeam;
        this.date = date;
        this.tournament = tournament;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public Match() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCountPointsFirstTeam() {
        return countPointsFirstTeam;
    }

    public void setCountPointsFirstTeam(Double countPointsFirstTeam) {
        this.countPointsFirstTeam = countPointsFirstTeam;
    }

    public Double getCountPointsSecondTeam() {
        return countPointsSecondTeam;
    }

    public void setCountPointsSecondTeam(Double countPointsSecondTeam) {
        this.countPointsSecondTeam = countPointsSecondTeam;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }
}
