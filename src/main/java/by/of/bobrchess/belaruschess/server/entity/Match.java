package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Proxy(lazy = false)
@Table(name = "match1")
public class Match {

    @Id
    @Column(name = "m_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "m_count_points_first_team", nullable = false)
    private Double countPointsFirstTeam;

    @Column(name = "m_count_points_second_team", nullable = false)
    private Double countPointsSecondTeam;

    @Column(name = "m_date", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "m_tournament_id", nullable = false)
    private Tournament tournament;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "m_first_team_id", nullable = false)
    private TournamentTeam firstTeam;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "m_second_team_id", nullable = false)
    private TournamentTeam secondTeam;

    public Match(Double countPointsFirstTeam, Double countPointsSecondTeam, Date date, Tournament tournament, TournamentTeam firstTeam, TournamentTeam secondTeam) {
        this.countPointsFirstTeam = countPointsFirstTeam;
        this.countPointsSecondTeam = countPointsSecondTeam;
        this.date = date;
        this.tournament = tournament;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public Match() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public TournamentTeam getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(TournamentTeam firstTeam) {
        this.firstTeam = firstTeam;
    }

    public TournamentTeam getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(TournamentTeam secondTeam) {
        this.secondTeam = secondTeam;
    }
}
