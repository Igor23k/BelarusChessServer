package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

import static by.of.bobrchess.belaruschess.server.util.Constants.INCORRECT_TEAM_ID;
import static by.of.bobrchess.belaruschess.server.util.Constants.INCORRECT_TEAM_NAME;
import static javax.persistence.CascadeType.ALL;

@Entity
@Proxy(lazy = false)
@Table(name = "team")
public class Team {

    @Id
    @Min(value = 1, message = INCORRECT_TEAM_ID)
    @Column(name = "tm_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Size(min = 3, max = 50, message = INCORRECT_TEAM_NAME)
    @Column(name = "tm_name", nullable = false, length = 50)
    private String name;

    @ManyToMany(cascade = ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "team_players", joinColumns = {
            @JoinColumn(name = "tm_id", referencedColumnName = "tm_id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "u_id", referencedColumnName = "u_id")
                    })
    private List<User> players;

    public Team(String name, List<User> players) {
        this.name = name;
        this.players = players;
    }

    public Team() {
    }

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

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }
}
