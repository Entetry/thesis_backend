package org.example.core.mapper;


import org.example.core.dto.HeightMeasureDto;
import org.example.core.dto.HeightMeasureRequestDto;
import org.example.core.dto.PorodaDto;
import org.example.core.entity.HeightMeasure;
import org.example.core.entity.Poroda;
import org.example.core.entity.TrialPlot;
import org.springframework.stereotype.Component;

@Component
public class HeightMeasureMapper {

    public HeightMeasureDto toHeightMeasureDto(HeightMeasure heightMeasure){
        HeightMeasureDto heightMeasureDto = new HeightMeasureDto();
        heightMeasureDto.setId(heightMeasure.getId());
        heightMeasureDto.setDiameter(heightMeasure.getDiameter());
        heightMeasureDto.setHeight(heightMeasure.getHeight());
        PorodaDto porodaDto = new PorodaDto();
        porodaDto.setAverageAge(heightMeasure.getPoroda().getAverageAge());
        porodaDto.setId(heightMeasure.getPoroda().getId());
        porodaDto.setPokolenie(heightMeasure.getPoroda().getPokolenie());
        porodaDto.setYarus(heightMeasure.getPoroda().getYarus());
        porodaDto.setPoroda(heightMeasure.getPoroda().getPoroda());
        heightMeasureDto.setPoroda(porodaDto);
        return heightMeasureDto;
    }
    public HeightMeasure toHeightMeasure(HeightMeasureDto heightMeasureDto){
        HeightMeasure heightMeasure = new HeightMeasure();
        if (heightMeasure.getId()!=null){
            heightMeasure.setId(heightMeasureDto.getId());
        }
        heightMeasure.setDiameter(heightMeasureDto.getDiameter());
        heightMeasure.setHeight(heightMeasure.getHeight());
        Poroda poroda = new Poroda();
        poroda.setAverageAge(heightMeasureDto.getPoroda().getAverageAge());
        poroda.setId(heightMeasureDto.getPoroda().getId());
        poroda.setPokolenie(heightMeasureDto.getPoroda().getPokolenie());
        poroda.setYarus(heightMeasureDto.getPoroda().getYarus());
        poroda.setPoroda(heightMeasureDto.getPoroda().getPoroda());
        heightMeasure.setPoroda(poroda);
        return heightMeasure;
    }
    public HeightMeasure toHeightMeasure(HeightMeasureRequestDto heightMeasureDto){
        HeightMeasure heightMeasure = new HeightMeasure();
        if (heightMeasure.getId()!=null){
            heightMeasure.setId(heightMeasureDto.getId());
        }
        heightMeasure.setDiameter(heightMeasureDto.getDiameter());
        heightMeasure.setHeight(heightMeasure.getHeight());
        Poroda poroda = new Poroda();
        poroda.setId(heightMeasureDto.getId());
        heightMeasure.setPoroda(poroda);
        return heightMeasure;
    }
}
