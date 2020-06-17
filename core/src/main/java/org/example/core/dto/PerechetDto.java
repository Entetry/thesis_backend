package org.example.core.dto;

public class PerechetDto {
    private Long id;
    private PorodaDto poroda;
    private Double stupen;
    private Integer delovyh;
    private Integer drovyanyh;
    private Integer suhostoynyh;
    private Double height;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PorodaDto getPoroda() {
        return poroda;
    }

    public void setPoroda(PorodaDto poroda) {
        this.poroda = poroda;
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

    public Double getStupen() {
        return stupen;
    }

    public void setStupen(Double stupen) {
        this.stupen = stupen;
    }
}
