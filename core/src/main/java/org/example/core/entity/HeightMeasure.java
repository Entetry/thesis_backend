package org.example.core.entity;

import javax.persistence.*;

@Entity(name = "HeightMeasure")
@Table(name = "vp_height_measure")
public class HeightMeasure extends AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poroda_id")
    private Poroda poroda;
    @Column(name = "diameter")
    private Double diameter;
    @Column(name = "height")
    private Double height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Poroda getPoroda() {
        return poroda;
    }

    public void setPoroda(Poroda poroda) {
        this.poroda = poroda;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
