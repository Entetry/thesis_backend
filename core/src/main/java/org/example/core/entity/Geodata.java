package org.example.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "vp_geodata")
public class Geodata extends AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plot_id")
    private TrialPlot trialPlot;
    @Column(name = "coordinateX")
    private Double x;
    @Column(name = "coordinateY")
    private Double y;
    @Column(name = "directionAngle")
    private Double directionAngle;
    @Column(name = "horizontalDistance")
    private Double horizontalDistance;
    @Column(name = "insideAngle")
    private Double insideAngle;
    @Column(name = "isBindingLine")
    private Double isBindingLine;
    @Column(name = "rhumb")
    private Double rhumb;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrialPlot getTrialPlot() {
        return trialPlot;
    }

    public void setTrialPlot(TrialPlot trialPlot) {
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

    public Double getIsBindingLine() {
        return isBindingLine;
    }

    public void setIsBindingLine(Double isBindingLine) {
        this.isBindingLine = isBindingLine;
    }

    public Double getRhumb() {
        return rhumb;
    }

    public void setRhumb(Double rhumb) {
        this.rhumb = rhumb;
    }
}
