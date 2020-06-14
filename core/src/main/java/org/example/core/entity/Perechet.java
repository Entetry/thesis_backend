package org.example.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "vp_perechet")
public class Perechet extends AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "poroda_id")
    private Poroda poroda;
    @Column(name = "stupen_tolschiny")
    private Double stupen;
    @Column(name = "delovyh")
    private Integer delovyh;
    @Column(name = "drovyanyh")
    private Integer drovyanyh;
    @Column(name = "suhostoynyh")
    private Integer suhostoynyh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getStupen() {
        return stupen;
    }

    public void setStupen(Double stupen) {
        this.stupen = stupen;
    }

    public Poroda getPoroda() {
        return poroda;
    }

    public void setPoroda(Poroda porodaId) {
        this.poroda = porodaId;
    }

    public Integer getDelovyh() {
        return delovyh;
    }

    public void setDelovyh(Integer delovyh) {
        this.delovyh = delovyh;
    }

    public Integer getDrovyanyh() {
        return drovyanyh;
    }

    public void setDrovyanyh(Integer drovyanyh) {
        this.drovyanyh = drovyanyh;
    }

    public Integer getSuhostoynyh() {
        return suhostoynyh;
    }

    public void setSuhostoynyh(Integer suhostoynyh) {
        this.suhostoynyh = suhostoynyh;
    }
}

