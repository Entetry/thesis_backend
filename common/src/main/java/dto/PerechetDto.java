package dto;

public class PerechetDto {
    private Long id;
    private PorodaDto poroda;
    private Integer stupen;
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

    public Integer getStupen() {
        return stupen;
    }

    public void setStupen(Integer stupen) {
        this.stupen = stupen;
    }
}