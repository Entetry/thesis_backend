package org.example.core.dto;

import org.example.core.entity.PorodaInfo;

import java.util.ArrayList;
import java.util.List;

public class PorodaRequestDto {
    private Long id;
    private Long plotId;
    private Long porodaId;
    private String pokolenie;
    private String yarus;
    private Double averageAge;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public Long getPorodaId() {
        return porodaId;
    }

    public void setPorodaId(Long porodaId) {
        this.porodaId = porodaId;
    }

    public String getPokolenie() {
        return pokolenie;
    }

    public void setPokolenie(String pokolenie) {
        this.pokolenie = pokolenie;
    }

    public String getYarus() {
        return yarus;
    }

    public void setYarus(String yarus) {
        this.yarus = yarus;
    }

    public Double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(Double averageAge) {
        this.averageAge = averageAge;
    }

}
