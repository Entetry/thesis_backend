package org.example.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vp_poroda")
public class Poroda extends AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plot_id")
    private TrialPlot plot;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "poroda")
    private PorodaInfo poroda;
    @Column(name = "pokolenie")
    private String pokolenie;
    @Column(name = "yarus")
    private String yarus;
    @Column(name = "average_age")
    private Double averageAge;
    @OneToMany(mappedBy = "poroda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Perechet> perechetList = new ArrayList<>();
    @OneToMany(mappedBy = "poroda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HeightMeasure> heightMeasureList = new ArrayList<>();

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

    public List<Perechet> getPerechetList() {
        return perechetList;
    }

    public void setPerechetList(List<Perechet> perechetList) {
        this.perechetList = perechetList;
    }

    public List<HeightMeasure> getHeightMeasureList() {
        return heightMeasureList;
    }

    public void setHeightMeasureList(List<HeightMeasure> heightMeasureList) {
        this.heightMeasureList = heightMeasureList;
    }
}
