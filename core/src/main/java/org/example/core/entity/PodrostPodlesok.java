package org.example.core.entity;

import javax.persistence.*;

@Entity(name = "PodrostPodlesok")
@Table(name = "vp_podrost_podles")
public class PodrostPodlesok {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plot_id")
    private TrialPlot plot;
    @Column(name = "nomer_ploshadok")
    private Integer nomerPloshadok;
    @Column(name = "podrost_zdorov")
    private Integer podrostHealthy;
    @Column(name = "podrost_damaged")
    private Integer podrostDamaged;
    @Column(name = "podrost_dry")
    private Integer podrostDry;
    @Column(name = "podrost_height")
    private Integer podrostHeight;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "poroda")
    private PorodaInfo poroda;
    @Column(name = "podles_poroda")
    private String podlesPoroda;
    @Column(name = "podles_quantity")
    private Integer podlesQuantity;
    @Column(name = "podles_height")
    private Integer podles_height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrialPlot getPlot() {
        return plot;
    }

    public void setPlot(TrialPlot plot) {
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
