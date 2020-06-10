package org.example.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "TrialPlot")
@Table(name = "vp_trial_plot")
public class TrialPlot extends AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leshoz")
    private Leshos leshoz;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lesnichestvo")
    private Lesnichestvo lesnichestvo;
    @Column(name = "kvartal")
    private String kvartal;
    @Column(name = "videl")
    private String videl;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oblast")
    private Oblast oblast;
    @Column(name = "position_relief")
    private String positionAndRelief;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokrov")
    private Pokrov pokrov;
    @Column(name = "osobenosti_drev")
    private String osobennostiDrev;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "forest_type")
    private ForestType forestType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tym")
    private Tym tym;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rayon")
    private Rayon rayon;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pochva")
    private Pochva pochva;
    @Column(name = "ispolnitel")
    private String ispolnitel;
    @Column(name = "ploshad_probi")
    private Double ploshadProbi;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plho")
    private Plho plho;
    @OneToMany(mappedBy = "plot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Poroda> porodaList = new ArrayList<>();
    @OneToMany(mappedBy = "trialPlot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Geodata> geodatas = new ArrayList<>();
//    @OneToMany(mappedBy = "plot", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Podrost> podrostList = new ArrayList<>();
//    @OneToMany(mappedBy = "plot", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Podlesok> podlesokList = new ArrayList<>();


    public Leshos getLeshoz() {
        return leshoz;
    }

    public void setLeshoz(Leshos leshoz) {
        this.leshoz = leshoz;
    }

    public Lesnichestvo getLesnichestvo() {
        return lesnichestvo;
    }

    public void setLesnichestvo(Lesnichestvo lesnichestvo) {
        this.lesnichestvo = lesnichestvo;
    }

    public Oblast getOblast() {
        return oblast;
    }

    public void setOblast(Oblast oblast) {
        this.oblast = oblast;
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

    public String getIspolnitel() {
        return ispolnitel;
    }

    public void setIspolnitel(String ispolnitel) {
        this.ispolnitel = ispolnitel;
    }

    public Double getPloshadProbi() {
        return ploshadProbi;
    }

    public List<Poroda> getPorodaList() {
        return porodaList;
    }

    public void setPorodaList(List<Poroda> porodaList) {
        this.porodaList = porodaList;
    }

    public void setPloshadProbi(Double ploshadProbi) {
        this.ploshadProbi = ploshadProbi;
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

    public List<Geodata> getGeodatas() {
        return geodatas;
    }

    public void setGeodatas(List<Geodata> geodatas) {
        this.geodatas = geodatas;
    }
}
