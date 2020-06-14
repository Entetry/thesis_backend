package org.example.core.dto;

import org.example.core.entity.PorodaInfo;
import org.example.core.entity.TrialPlot;

import javax.persistence.*;

public class PodrostPodlesokDto {
    private Long id;
    private TrialPlotDto plot;
    private Integer nomerPloshadok;
    private Integer podrostHealthy;
    private Integer podrostDamaged;
    private Integer podrostDry;
    private Integer podrostHeight;
    private PorodaInfo poroda;
    private String podlesPoroda;
    private Integer podlesQuantity;
    private Integer podles_height;

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

    public Integer getNomerPloshadok() {
        return nomerPloshadok;
    }

    public void setNomerPloshadok(Integer nomerPloshadok) {
        this.nomerPloshadok = nomerPloshadok;
    }

    public Integer getPodrostHealthy() {
        return podrostHealthy;
    }

    public void setPodrostHealthy(Integer podrostHealthy) {
        this.podrostHealthy = podrostHealthy;
    }

    public Integer getPodrostDamaged() {
        return podrostDamaged;
    }

    public void setPodrostDamaged(Integer podrostDamaged) {
        this.podrostDamaged = podrostDamaged;
    }

    public Integer getPodrostDry() {
        return podrostDry;
    }

    public void setPodrostDry(Integer podrostDry) {
        this.podrostDry = podrostDry;
    }

    public Integer getPodrostHeight() {
        return podrostHeight;
    }

    public void setPodrostHeight(Integer podrostHeight) {
        this.podrostHeight = podrostHeight;
    }

    public PorodaInfo getPoroda() {
        return poroda;
    }

    public void setPoroda(PorodaInfo poroda) {
        this.poroda = poroda;
    }

    public String getPodlesPoroda() {
        return podlesPoroda;
    }

    public void setPodlesPoroda(String podlesPoroda) {
        this.podlesPoroda = podlesPoroda;
    }

    public Integer getPodlesQuantity() {
        return podlesQuantity;
    }

    public void setPodlesQuantity(Integer podlesQuantity) {
        this.podlesQuantity = podlesQuantity;
    }

    public Integer getPodles_height() {
        return podles_height;
    }

    public void setPodles_height(Integer podles_height) {
        this.podles_height = podles_height;
    }
}
