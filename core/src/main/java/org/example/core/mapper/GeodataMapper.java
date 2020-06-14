package org.example.core.mapper;

import org.example.core.dto.GeodataRequestDto;
import org.example.core.entity.Geodata;
import org.springframework.stereotype.Component;

@Component
public class GeodataMapper {
    public Geodata toGeodata(GeodataRequestDto geodataRequestDto){
        Geodata geodata = new Geodata();
        geodata.setX(geodataRequestDto.getX());
        geodata.setY(geodataRequestDto.getY());
        geodata.setDirectionAngle(geodataRequestDto.getDirectionAngle());
        geodata.setHorizontalDistance(geodataRequestDto.getDirectionAngle());
        geodata.setInsideAngle(geodataRequestDto.getInsideAngle());
        geodata.setRhumb(geodataRequestDto.getRhumb());
        geodata.setTrialPlot(geodataRequestDto.getTrialPlotId());
        geodata.setNumber(geodataRequestDto.getNumber());
        return geodata;
    }
    public GeodataRequestDto toGeodataRequestDto(Geodata geodata){
        GeodataRequestDto geodataRequestDto = new GeodataRequestDto();
        geodataRequestDto.setX(geodata.getX());
        geodataRequestDto.setY(geodata.getY());
        geodataRequestDto.setDirectionAngle(geodata.getDirectionAngle());
        geodataRequestDto.setHorizontalDistance(geodata.getDirectionAngle());
        geodataRequestDto.setInsideAngle(geodata.getInsideAngle());
        geodataRequestDto.setRhumb(geodata.getRhumb());
        geodataRequestDto.setTrialPlotId(geodata.getTrialPlot());
        geodataRequestDto.setNumber(geodata.getNumber());
        return geodataRequestDto;
    }
}
