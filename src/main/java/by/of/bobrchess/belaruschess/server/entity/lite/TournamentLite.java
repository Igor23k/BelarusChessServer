package by.of.bobrchess.belaruschess.server.entity.lite;

import by.of.bobrchess.belaruschess.server.entity.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

import static by.of.bobrchess.belaruschess.server.util.Constants.*;

@Entity
@Proxy(lazy = false)
@Table(name = "tournament")
public class TournamentLite {

    @Id
    @Min(value = 1, message = INCORRECT_TOURNAMENT_ID)
    @Column(name = "tr_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Min(value = 1, message = INCORRECT_TOURNAMENT_TOURS_COUNT)
    @Column(name = "tr_tours_count", nullable = false)
    private Integer toursCount;

    @Size(min = 8, max = 100, message = INCORRECT_TOURNAMENT_NAME)
    @Column(name = "tr_name", nullable = false, length = 100)
    private String name;

    @Size(min = 100, max = 10000, message = INCORRECT_TOURNAMENT_FULL_DESCRIPTION)
    @Column(name = "tr_full_description", nullable = false, length = 10000)
    private String fullDescription;

    @Column(name = "tr_start", nullable = false)
    private Date startDate;

    @Column(name = "tr_finish", nullable = false)
    private Date finishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tr_place_id", nullable = false)
    private PlaceLite place;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tr_referee_id", nullable = false)
    private UserLite referee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tr_created_by", nullable = false)
    private UserLite createdBy;

    @Lob
    @Column(name = "tr_image", columnDefinition = "MEDIUMBLOB", nullable = true)
    private Byte[] image;

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

    public Integer getToursCount() {
        return toursCount;
    }

    public void setToursCount(Integer toursCount) {
        this.toursCount = toursCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public PlaceLite getPlace() {
        return place;
    }

    public void setPlace(PlaceLite place) {
        this.place = place;
    }

    public UserLite getReferee() {
        return referee;
    }

    public void setReferee(UserLite referee) {
        this.referee = referee;
    }

    public UserLite getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserLite createdBy) {
        this.createdBy = createdBy;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public TournamentLite(@Min(1) Integer toursCount, @Size(min = 8, max = 50) String name, @Size(min = 10, max = 100) String fullDescription, Date startDate, Date finishDate, PlaceLite place, UserLite referee, Byte[] image, UserLite createdBy) {
        this.toursCount = toursCount;
        this.name = name;
        this.fullDescription = fullDescription;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.place = place;
        this.referee = referee;
        this.createdBy = createdBy;
        this.image = image;

    }

    public TournamentLite() {
    }
}
