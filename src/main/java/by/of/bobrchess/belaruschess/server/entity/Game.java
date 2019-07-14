package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import static by.of.bobrchess.belaruschess.server.util.Constants.*;

@Entity
@Proxy(lazy = false)
@Table(name = "game")
public class Game {

    @Id
    @Min(value = 1, message = INCORRECT_GAME_ID)
    @Column(name = "g_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Size(min = 2, max = 10000, message = INCORRECT_GAME_RECORD)
    @Column(name = "g_game_record", length = 10000)
    private String gameRecord;

    @Min(value = 0, message = INCORRECT_COUNT_POINTS_OF_PLAYER_SMALL)
    @Max(value = 1, message = INCORRECT_COUNT_POINTS_OF_PLAYER_BIG)
    @Column(name = "g_count_points_first_player", nullable = false)
    private Double countPointsFirstPlayer;

    @Min(value = 0, message = INCORRECT_GAME_ID)
    @Max(value = 1, message = INCORRECT_GAME_ID)
    @Column(name = "g_count_points_second_player", nullable = false)
    private Double countPointsSecondPlayer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "g_match_id", nullable = false)
    private Match match;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "g_first_chess_player_id", nullable = false)
    private User firstChessPlayer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "g_second_chess_player_id", nullable = false)
    private User secondChessPlayer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameRecord() {
        return gameRecord;
    }

    public void setGameRecord(String gameRecord) {
        this.gameRecord = gameRecord;
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

    public void setMatch(Match match) {
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

    public Game(String gameRecord, Double countPointsFirstPlayer, Double countPointsSecondPlayer, Match match, User firstChessPlayer, User secondChessPlayer) {
        this.gameRecord = gameRecord;
        this.countPointsFirstPlayer = countPointsFirstPlayer;
        this.countPointsSecondPlayer = countPointsSecondPlayer;
        this.match = match;
        this.firstChessPlayer = firstChessPlayer;
        this.secondChessPlayer = secondChessPlayer;
    }

    public Game() {

    }
}
