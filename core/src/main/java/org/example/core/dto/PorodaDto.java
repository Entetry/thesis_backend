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
    private Integer amoutDelovih;
    private Integer totalAmount;
    private Double polnota;
    private String bonitetClass;
    private String sostavCoeficient;
    private Double yieldPercentage;

    public Double getYieldPercentage() {
        return yieldPercentage;
    }

    public void setYieldPercentage(Double yieldPercentage) {
        this.yieldPercentage = yieldPercentage;
    }

    public String getSostavCoeficient() {
        return sostavCoeficient;
    }

    public void setSostavCoeficient(String sostavCoeficient) {
        this.sostavCoeficient = sostavCoeficient;
    }

    public String getBonitetClass() {
        return bonitetClass;
    }

    public void setBonitetClass(String bonitetClass) {
        this.bonitetClass = bonitetClass;
    }

    public Double getPolnota() {
        return polnota;
    }

    public void setPolnota(Double polnota) {
        this.polnota = polnota;
    }

    public Integer getAmoutDelovih() {
        return amoutDelovih;
    }

    public void setAmoutDelovih(Integer amoutDelovih) {
        this.amoutDelovih = amoutDelovih;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

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
