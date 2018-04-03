package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Proxy(lazy = false)
@Table(name = "chess_player")
public class ChessPlayer {

    @Id
    @Column(name = "ch_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @Column(name = "ch_rating", nullable = false)
    private Integer rating;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ch_person_id", nullable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ch_coach_id", nullable = false)
    private Person coach;

    //private Set<TournamentTeam> teams;

    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ch_chess_player_id", joinColumns = @JoinColumn(name = "ch_id", referencedColumnName = "ch_id"),
            inverseJoinColumns = @JoinColumn(name = "tm_tournament_team_id", referencedColumnName = "tm_id"))
    public Set<TournamentTeam> getTeams() {
        return teams;
    }*/

    public ChessPlayer(Integer rating, Person person, Person coach, Set<TournamentTeam> teams) {
        this.rating = rating;
        this.person = person;
        this.coach = coach;
        //this.teams = teams;
    }

    public ChessPlayer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getCoach() {
        return coach;
    }

    public void setCoach(Person coach) {
        this.coach = coach;
    }

    /*public void setTeams(Set<TournamentTeam> teams) {
        this.teams = teams;
    }*/
}
