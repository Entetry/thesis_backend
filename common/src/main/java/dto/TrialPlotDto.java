package dto;

import java.util.ArrayList;
import java.util.List;

public class TrialPlotDto {
    private Long id;
    private String leshoz;
    private String lesnichestvo;
    private String kvartal;
    private String videl;
    private String oblast;
    private String positionAndRelief;
    private String pokrov;
    private String osobennostiDrev;
    private String forestType;
    private String tym;
    private String district;
    private String pochva;
    private String ispolnitel;
    private Double ploshadProbi;
    private List<PorodaDto> porodaList = new ArrayList<>();

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

    public String getLeshoz() {
        return leshoz;
    }

    public void setLeshoz(String leshoz) {
        this.leshoz = leshoz;
    }

    public String getLesnichestvo() {
        return lesnichestvo;
    }

    public void setLesnichestvo(String lesnichestvo) {
        this.lesnichestvo = lesnichestvo;
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

    public String getOblast() {
        return oblast;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    public String getPositionAndRelief() {
        return positionAndRelief;
    }

    public void setPositionAndRelief(String positionAndRelief) {
        this.positionAndRelief = positionAndRelief;
    }

    public String getPokrov() {
        return pokrov;
    }

    public void setPokrov(String pokrov) {
        this.pokrov = pokrov;
    }

    public String getOsobennostiDrev() {
        return osobennostiDrev;
    }

    public void setOsobennostiDrev(String osobennostiDrev) {
        this.osobennostiDrev = osobennostiDrev;
    }

    public String getForestType() {
        return forestType;
    }

    public void setForestType(String forestType) {
        this.forestType = forestType;
    }

    public String getTym() {
        return tym;
    }

    public void setTym(String tym) {
        this.tym = tym;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPochva() {
        return pochva;
    }

    public void setPochva(String pochva) {
        this.pochva = pochva;
    }
}
