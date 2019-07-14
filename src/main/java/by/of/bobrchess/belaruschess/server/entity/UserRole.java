package by.of.bobrchess.belaruschess.server.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Min;

import static by.of.bobrchess.belaruschess.server.util.Constants.INCORRECT_PLACE_ID;
import static javax.persistence.CascadeType.MERGE;

@Entity
@Proxy(lazy = false)
@Table(name = "user_role")
public class UserRole {

    @Id
    @Min(value = 1, message = INCORRECT_PLACE_ID)
    @Column(name = "ur_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = MERGE)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public UserRole() {
    }

    public UserRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
