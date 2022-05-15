package by.of.bobrchess.belaruschess.server.entity.future;

public class UserTournamentResult {

    private String name;
    private Integer position;
    private Double points;
    private String startDate;
    private String image;

    public UserTournamentResult(String name, Double points, Integer position, String startDate, String image) {
        this.name = name;
        this.position = position;
        this.points = points;
        this.startDate = startDate;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
