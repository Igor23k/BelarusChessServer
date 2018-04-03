package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Proxy(lazy = false)
@Table(name = "tournamentTeam")
public class TournamentTeam {

    @Id
    @Column(name = "tm_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "tm_name", nullable = false, length = 50)
    private String name;


    //private Set<ChessPlayer> chessPlayers;

    /*@ManyToMany(mappedBy = "teams")
    public Set<ChessPlayer> getChessPlayers() {
        return chessPlayers;
    }*/

    public TournamentTeam(String name/*, Set<ChessPlayer> chessPlayers*/) {
        this.name = name;
        //this.chessPlayers = chessPlayers;
    }

    public TournamentTeam() {
    }
}
