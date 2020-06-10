package org.example.core.dto;

public class PerechetRequestDto {
    private Long id;
    private Long porodaId;
    private Double stupen;
    private Integer delovyh;
    private Integer drovyanyh;
    private Integer ysyhauchih;
    private Integer suhostoynyh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPorodaId() {
        return porodaId;
    }

    public void setPorodaId(Long porodaId) {
        this.porodaId = porodaId;
    }

    public Double getStupen() {
        return stupen;
    }

    public void setStupen(Double stupen) {
        this.stupen = stupen;
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

    public Integer getYsyhauchih() {
        return ysyhauchih;
    }

    public void setYsyhauchih(Integer ysyhauchih) {
        this.ysyhauchih = ysyhauchih;
    }

    public Integer getSuhostoynyh() {
        return suhostoynyh;
    }

    public void setSuhostoynyh(Integer suhostoynyh) {
        this.suhostoynyh = suhostoynyh;
    }
}
