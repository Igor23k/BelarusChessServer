package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
@Table(name = "game")
public class Game {
    @Id
    @Column(name = "g_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "g_game_record",length = 10000)
    private String name;

    @Column(name = "g_count_points_first_player", nullable = false)
    private Double countPointsFirstPlayer;

    @Column(name = "g_count_points_second_player", nullable = false)
    private Double countPointsSecondPlayer;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "g_match_id", nullable = false)
    private Match match;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "g_first_chess_player_id", nullable = false)
    private User firstChessPlayer;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "g_second_chess_player_id", nullable = false)
    private User secondChessPlayer;

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

    public Double getCountPointsFirstPlayer() {
        return countPointsFirstPlayer;
    }

    public void setCountPointsFirstPlayer(Double countPointsFirstPlayer) {
        this.countPointsFirstPlayer = countPointsFirstPlayer;
    }

    public Double getCountPointsSecondPlayer() {
        return countPointsSecondPlayer;
    }

    public void setCountPointsSecondPlayer(Double countPointsSecondPlayer) {
        this.countPointsSecondPlayer = countPointsSecondPlayer;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match  match) {
        this.match = match;
    }

    public User getFirstChessPlayer() {
        return firstChessPlayer;
    }

    public void setFirstChessPlayer(User firstChessPlayer) {
        this.firstChessPlayer = firstChessPlayer;
    }

    public User getSecondChessPlayer() {
        return secondChessPlayer;
    }

    public void setSecondChessPlayer(User secondChessPlayer) {
        this.secondChessPlayer = secondChessPlayer;
    }

    public Game(String name, Double countPointsFirstPlayer, Double countPointsSecondPlayer, Match match, User firstChessPlayer, User secondChessPlayer) {
        this.name = name;
        this.countPointsFirstPlayer = countPointsFirstPlayer;
        this.countPointsSecondPlayer = countPointsSecondPlayer;
        this.match = match;
        this.firstChessPlayer = firstChessPlayer;
        this.secondChessPlayer = secondChessPlayer;
    }

    public Game() {

}}
