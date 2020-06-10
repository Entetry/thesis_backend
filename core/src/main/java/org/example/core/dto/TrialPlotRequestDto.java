package org.example.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.core.entity.*;

import java.util.ArrayList;
import java.util.List;

public class TrialPlotRequestDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private Long leshosId;
    @JsonProperty
    private Long lesnichestvoId;
    @JsonProperty
    private String kvartal;
    @JsonProperty
    private String videl;
    @JsonProperty
    private Long regionId;
    @JsonProperty
    private String positionAndRelief;
    @JsonProperty
    private Long pokrovId;
    @JsonProperty
    private String osobennostiDrev;
    @JsonProperty
    private Long forestTypeId;
    @JsonProperty
    private Long tymId;
    @JsonProperty
    private Long rayonId;
    @JsonProperty
    private Long pochvaId;
    @JsonProperty
    private String ispolnitel;
    @JsonProperty
    private Double ploshadProbi;
    @JsonProperty
    private Long plhoId;
    private List<PorodaDto> porodaList = new ArrayList<>();
    @JsonProperty
    private Double summPlSech;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLeshosId() {
        return leshosId;
    }

    public void setLeshosId(Long leshosId) {
        this.leshosId = leshosId;
    }

    public Long getLesnichestvoId() {
        return lesnichestvoId;
    }

    public void setLesnichestvoId(Long lesnichestvoId) {
        this.lesnichestvoId = lesnichestvoId;
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

    public Long getOblastId() {
        return regionId;
    }

    public void setOblastId(Long oblastId) {
        this.regionId = oblastId;
    }

    public String getPositionAndRelief() {
        return positionAndRelief;
    }

    public void setPositionAndRelief(String positionAndRelief) {
        this.positionAndRelief = positionAndRelief;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getPokrovId() {
        return pokrovId;
    }

    public void setPokrovId(Long pokrovId) {
        this.pokrovId = pokrovId;
    }

    public Long getForestTypeId() {
        return forestTypeId;
    }

    public void setForestTypeId(Long forestTypeId) {
        this.forestTypeId = forestTypeId;
    }

    public Long getTymId() {
        return tymId;
    }

    public void setTymId(Long tymId) {
        this.tymId = tymId;
    }

    public Long getPochvaId() {
        return pochvaId;
    }

    public void setPochvaId(Long pochvaId) {
        this.pochvaId = pochvaId;
    }

    public String getOsobennostiDrev() {
        return osobennostiDrev;
    }

    public void setOsobennostiDrev(String osobennostiDrev) {
        this.osobennostiDrev = osobennostiDrev;
    }



    public Long getRayonId() {
        return rayonId;
    }

    public void setRayonId(Long rayonId) {
        this.rayonId = rayonId;
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

    public Long getPlhoId() {
        return plhoId;
    }

    public void setPlhoId(Long plhoId) {
        this.plhoId = plhoId;
    }

    public List<PorodaDto> getPorodaList() {
        return porodaList;
    }

    public void setPorodaList(List<PorodaDto> porodaList) {
        this.porodaList = porodaList;
    }

    public Double getSummPlSech() {
        return summPlSech;
    }

    public void setSummPlSech(Double summPlSech) {
        this.summPlSech = summPlSech;
    }

}
