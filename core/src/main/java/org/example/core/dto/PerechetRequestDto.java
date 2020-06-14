package org.example.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PerechetRequestDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private Long porodaId;
    @JsonProperty
    private Double stupen;
    @JsonProperty
    private Integer delovyh;
    @JsonProperty
    private Integer drovyanyh;
    @JsonProperty
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

    public Integer getSuhostoynyh() {
        return suhostoynyh;
    }

    public void setSuhostoynyh(Integer suhostoynyh) {
        this.suhostoynyh = suhostoynyh;
    }
}
