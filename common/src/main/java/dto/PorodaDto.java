package dto;

import java.util.ArrayList;
import java.util.List;

public class PorodaDto {
    private Long id;
    private TrialPlotDto plot;
    private String poroda;
    private String pokolenie;
    private String yarus;
    private Double averageAge;
    private List<PerechetDto> perechetList = new ArrayList<>();
    private List<HeightMeasureDto> heightMeasureList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrialPlotDto getPlot() {
        return plot;
    }

    public void setPlot(TrialPlotDto plot) {
        this.plot = plot;
    }

    public String getPoroda() {
        return poroda;
    }

    public void setPoroda(String poroda) {
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

    public List<PerechetDto> getPerechetList() {
        return perechetList;
    }

    public void setPerechetList(List<PerechetDto> perechetList) {
        this.perechetList = perechetList;
    }

    public List<HeightMeasureDto> getHeightMeasureList() {
        return heightMeasureList;
    }

    public void setHeightMeasureList(List<HeightMeasureDto> heightMeasureList) {
        this.heightMeasureList = heightMeasureList;
    }
}
