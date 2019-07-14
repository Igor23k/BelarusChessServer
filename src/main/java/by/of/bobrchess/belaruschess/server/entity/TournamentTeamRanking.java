package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Min;

import static by.of.bobrchess.belaruschess.server.util.Constants.*;


@Entity
@Proxy(lazy = false)
@Table(name = "tournamentTeamRanking")
public class TournamentTeamRanking {

    @Id()
    @Min(value = 1, message = INCORRECT_TOURNAMENT_TEAM_ID)
    @Column(name = "g_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Min(value = 1, message = INCORRECT_TOURNAMENT_TEAM_POSITION)
    @Column(name = "ttr_position", nullable = false)
    private Integer position;

    @Min(value = 0, message = INCORRECT_TOURNAMENT_TEAM_COUNT_POINTS)
    @Column(name = "ttr_points", nullable = false)
    private Double points;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ttr_team_id", nullable = false)
    private Team team;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ttr_tournament_id", nullable = false)
    private Tournament tournament;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public TournamentTeamRanking(Integer position, Double points, Team team, Tournament tournament) {
        this.position = position;
        this.points = points;
        this.team = team;
        this.tournament = tournament;
    }

    public TournamentTeamRanking() {
    }
}
