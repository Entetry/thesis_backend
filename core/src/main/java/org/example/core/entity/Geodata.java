package org.example.core.entity;



import javax.persistence.*;

@Entity
@Table(name = "vp_privjazka")
public class Geodata extends AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "plot_navigation_id")
    private Long trialPlot;
    @Column(name = "number")
    private Integer number;
    @Column(name = "`x`")
    private Double x;
    @Column(name = "`y`")
    private Double y;
    @Column(name = "`ug`")
    private Double directionAngle;
    @Column(name = "`horizontaldistance`")
    private Double horizontalDistance;
    @Column(name = "`vug`")
    private Double insideAngle;
    @Column(name = "`rumb`")
    private Double rhumb;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrialPlot() {
        return trialPlot;
    }

    public void setTrialPlot(Long trialPlot) {
        this.trialPlot = trialPlot;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getDirectionAngle() {
        return directionAngle;
    }

    public void setDirectionAngle(Double directionAngle) {
        this.directionAngle = directionAngle;
    }

    public Double getHorizontalDistance() {
        return horizontalDistance;
    }

    public void setHorizontalDistance(Double horizontalDistance) {
        this.horizontalDistance = horizontalDistance;
    }

    public Double getInsideAngle() {
        return insideAngle;
    }

    public void setInsideAngle(Double insideAngle) {
        this.insideAngle = insideAngle;
    }
    public Double getRhumb() {
        return rhumb;
    }

    public void setRhumb(Double rhumb) {
        this.rhumb = rhumb;
    }
}
