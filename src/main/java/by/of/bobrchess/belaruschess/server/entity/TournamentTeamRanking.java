package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
@Table(name = "tournamentTeamRanking")
public class TournamentTeamRanking {

    @Id
    @Column(name = "g_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "ttr_position", nullable = false)
    private Integer position;

    @Column(name = "ttr_points", nullable = false)
    private Double points;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ttr_team_id", nullable = false)
    private TournamentTeam team;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
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

    public TournamentTeam getTeam() {
        return team;
    }

    public void setTeam(TournamentTeam team) {
        this.team = team;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public TournamentTeamRanking(Integer position, Double points, TournamentTeam team, Tournament tournament) {
        this.position = position;
        this.points = points;
        this.team = team;
        this.tournament = tournament;
    }

    public TournamentTeamRanking() {
    }
}
