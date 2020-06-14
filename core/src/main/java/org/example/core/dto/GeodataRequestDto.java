package org.example.core.dto;

import org.example.core.entity.TrialPlot;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class GeodataRequestDto {
    private Long id;
    private Long trialPlotId;
    private Double x;
    private Double y;
    private Double directionAngle;
    private Double horizontalDistance;
    private Double insideAngle;
    private Double rhumb;
    private Integer number;

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

    public Long getTrialPlotId() {
        return trialPlotId;
    }

    public void setTrialPlotId(Long trialPlotId) {
        this.trialPlotId = trialPlotId;
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
