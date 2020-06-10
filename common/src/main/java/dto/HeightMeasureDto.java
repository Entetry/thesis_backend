package dto;

public class HeightMeasureDto {
    private Long id;
    private PorodaDto poroda;
    private Double diameter;
    private Double height;

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
