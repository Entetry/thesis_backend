package org.example.core.dto;

import org.example.core.entity.*;

import java.util.ArrayList;
import java.util.List;

public class TrialPlotDto {
    private Long id;
    private Leshos leshos;
    private Lesnichestvo lesnichestvo;
    private String kvartal;
    private String videl;
    private Oblast region;
    private String positionAndRelief;
    private Pokrov pokrov;
    private String osobennostiDrev;
    private ForestType forestType;
    private Tym tym;
    private Rayon rayon;
    private Pochva pochva;
    private String ispolnitel;
    private Double ploshadProbi;
    private Plho plho;
    private List<PorodaDto> porodaList = new ArrayList<>();
    private Double summPlSech;



    public Double getSummPlSech() {
        return summPlSech;
    }

    public void setSummPlSech(Double summPlSech) {
        this.summPlSech = summPlSech;
    }

    public String getIspolnitel() {
        return ispolnitel;
    }

    public void setIspolnitel(String ispolnitel) {
        this.ispolnitel = ispolnitel;
    }

    public Double getPloshadProbi() {
        return ploshadProbi;
    }

    public void setPloshadProbi(Double ploshadProbi) {
        this.ploshadProbi = ploshadProbi;
    }

    public List<PorodaDto> getPorodaList() {
        return porodaList;
    }

    public void setPorodaList(List<PorodaDto> porodaList) {
        this.porodaList = porodaList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getKvartal() {
        return kvartal;
    }

    public void setKvartal(String kvartal) {
        this.kvartal = kvartal;
    }

    public String getVidel() {
        return videl;
    }

    public void setVidel(String videl) {
        this.videl = videl;
    }



    public String getPositionAndRelief() {
        return positionAndRelief;
    }

    public void setPositionAndRelief(String positionAndRelief) {
        this.positionAndRelief = positionAndRelief;
    }


    public String getOsobennostiDrev() {
        return osobennostiDrev;
    }

    public void setOsobennostiDrev(String osobennostiDrev) {
        this.osobennostiDrev = osobennostiDrev;
    }



    public Leshos getLeshoz() {
        return leshos;
    }

    public void setLeshoz(Leshos leshoz) {
        this.leshos = leshoz;
    }

    public Lesnichestvo getLesnichestvo() {
        return lesnichestvo;
    }

    public void setLesnichestvo(Lesnichestvo lesnichestvo) {
        this.lesnichestvo = lesnichestvo;
    }

    public Oblast getOblast() {
        return region;
    }

    public void setOblast(Oblast oblast) {
        this.region = oblast;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public Plho getPlho() {
        return plho;
    }

    public void setPlho(Plho plho) {
        this.plho = plho;
    }

    public Leshos getLeshos() {
        return leshos;
    }

    public void setLeshos(Leshos leshos) {
        this.leshos = leshos;
    }

    public Oblast getRegion() {
        return region;
    }

    public void setRegion(Oblast region) {
        this.region = region;
    }

    public Pokrov getPokrov() {
        return pokrov;
    }

    public void setPokrov(Pokrov pokrov) {
        this.pokrov = pokrov;
    }

    public ForestType getForestType() {
        return forestType;
    }

    public void setForestType(ForestType forestType) {
        this.forestType = forestType;
    }

    public Tym getTym() {
        return tym;
    }

    public void setTym(Tym tym) {
        this.tym = tym;
    }

    public Pochva getPochva() {
        return pochva;
    }

    public void setPochva(Pochva pochva) {
        this.pochva = pochva;
    }
}
