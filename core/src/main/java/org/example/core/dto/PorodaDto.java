package org.example.core.dto;

import org.example.core.entity.PorodaInfo;

import java.util.ArrayList;
import java.util.List;

public class PorodaDto {
    private Long id;
    private TrialPlotDto plot;
    private PorodaInfo poroda;
    private String pokolenie;
    private String yarus;
    private Double averageAge;
    private List<PerechetDto> perechetList = new ArrayList<>();
    private List<HeightMeasureDto> heightMeasureList = new ArrayList<>();
    private Double averageDiameter;
    private Double summPloshSech;
    private Double averageHeight;
    private Double averageZapas;

    public Double getAverageZapas() {
        return averageZapas;
    }

    public void setAverageZapas(Double averageZapas) {
        this.averageZapas = averageZapas;
    }

    public Double getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(Double averageHeight) {
        this.averageHeight = averageHeight;
    }

    public Double getAverageDiameter() {
        return averageDiameter;
    }

    public void setAverageDiameter(Double averageDiameter) {
        this.averageDiameter = averageDiameter;
    }

    public Double getSummPloshSech() {
        return summPloshSech;
    }

    public void setSummPloshSech(Double summPloshSech) {
        this.summPloshSech = summPloshSech;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrialPlotDto getPlot() {
        return plot;
    }

    public void setPlot(TrialPlotDto plot) {
        this.plot = plot;
    }

    public PorodaInfo getPoroda() {
        return poroda;
    }

    public void setPoroda(PorodaInfo poroda) {
        this.poroda = poroda;
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

    public List<PerechetDto> getPerechetList() {
        return perechetList;
    }

    public void setPerechetList(List<PerechetDto> perechetList) {
        this.perechetList = perechetList;
    }

    public List<HeightMeasureDto> getHeightMeasureList() {
        return heightMeasureList;
    }

    public void setHeightMeasureList(List<HeightMeasureDto> heightMeasureList) {
        this.heightMeasureList = heightMeasureList;
    }
}
