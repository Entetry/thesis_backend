package org.example.core.mapper;



import org.example.core.dto.PorodaDto;
import org.example.core.dto.PorodaRequestDto;
import org.example.core.dto.TrialPlotDto;
import org.example.core.entity.Poroda;
import org.example.core.entity.TrialPlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PorodaMapper {
    private final HeightMeasureMapper heightMeasureMapper;
    private final PerechetMapper perechetMapper;
    @Autowired
    public PorodaMapper(HeightMeasureMapper heightMeasureMapper,PerechetMapper perechetMapper){
        this.heightMeasureMapper=heightMeasureMapper;
        this.perechetMapper=perechetMapper;
    }
    public PorodaDto toPorodaDto(Poroda poroda){
        PorodaDto porodaDto = new PorodaDto();
        porodaDto.setPoroda(poroda.getPoroda());
        porodaDto.setId(poroda.getId());
        porodaDto.setYarus(poroda.getYarus());
        porodaDto.setPokolenie(poroda.getPokolenie());
        porodaDto.setAverageAge(poroda.getAverageAge());
        porodaDto.setHeightMeasureList(poroda.getHeightMeasureList().stream().map(heightMeasureMapper::toHeightMeasureDto).collect(Collectors.toList()));
        porodaDto.setPerechetList(poroda.getPerechetList().stream().map(perechetMapper::toPerechetDto).collect(Collectors.toList()));
        TrialPlotDto trialPlotDto = new TrialPlotDto();
        trialPlotDto.setPochva(poroda.getPlot().getPochva());
        trialPlotDto.setPositionAndRelief(poroda.getPlot().getPositionAndRelief());
        trialPlotDto.setVidel(poroda.getPlot().getVidel());
        trialPlotDto.setTym(poroda.getPlot().getTym());
        trialPlotDto.setPokrov(poroda.getPlot().getPokrov());
        trialPlotDto.setOblast(poroda.getPlot().getOblast());
        trialPlotDto.setOsobennostiDrev(poroda.getPlot().getOsobennostiDrev());
        trialPlotDto.setLesnichestvo(poroda.getPlot().getLesnichestvo());
        trialPlotDto.setLeshoz(poroda.getPlot().getLeshoz());
        trialPlotDto.setKvartal(poroda.getPlot().getKvartal());
        trialPlotDto.setForestType(poroda.getPlot().getForestType());
        trialPlotDto.setPochva(poroda.getPlot().getPochva());
        trialPlotDto.setId(poroda.getPlot().getId());
        trialPlotDto.setRayon(poroda.getPlot().getRayon());
        trialPlotDto.setIspolnitel(poroda.getPlot().getIspolnitel());
        trialPlotDto.setPloshadProbi(poroda.getPlot().getPloshadProbi());
        porodaDto.setPlot(trialPlotDto);
        return porodaDto;
    }
    public Poroda toPoroda(PorodaDto porodaDto){
        Poroda poroda = new Poroda();
        poroda.setPoroda(porodaDto.getPoroda());
        poroda.setYarus(porodaDto.getYarus());
        poroda.setPokolenie(porodaDto.getPokolenie());
        poroda.setHeightMeasureList(porodaDto.getHeightMeasureList().stream().map(heightMeasureMapper::toHeightMeasure).collect(Collectors.toList()));
        poroda.setPerechetList(porodaDto.getPerechetList().stream().map(perechetMapper::toPerechet).collect(Collectors.toList()));
        if (porodaDto.getId()!=null){
            poroda.setId(porodaDto.getId());
        }
        TrialPlot trialPlot = new TrialPlot();
        trialPlot.setPochva(porodaDto.getPlot().getPochva());
        trialPlot.setPositionAndRelief(porodaDto.getPlot().getPositionAndRelief());
        trialPlot.setVidel(porodaDto.getPlot().getVidel());
        trialPlot.setTym(porodaDto.getPlot().getTym());
        trialPlot.setPokrov(porodaDto.getPlot().getPokrov());
        trialPlot.setOblast(porodaDto.getPlot().getOblast());
        trialPlot.setOsobennostiDrev(porodaDto.getPlot().getOsobennostiDrev());
        trialPlot.setLesnichestvo(porodaDto.getPlot().getLesnichestvo());
        trialPlot.setLeshoz(porodaDto.getPlot().getLeshoz());
        trialPlot.setKvartal(porodaDto.getPlot().getKvartal());
        trialPlot.setForestType(porodaDto.getPlot().getForestType());
        trialPlot.setPochva(porodaDto.getPlot().getPochva());
        trialPlot.setId(porodaDto.getPlot().getId());
        trialPlot.setRayon(porodaDto.getPlot().getRayon());
        trialPlot.setIspolnitel(porodaDto.getPlot().getIspolnitel());
        trialPlot.setPloshadProbi(porodaDto.getPlot().getPloshadProbi());
        poroda.setPlot(trialPlot);
        return poroda;
    }
    public Poroda toPoroda(PorodaRequestDto porodaRequestDto){
        Poroda poroda = new Poroda();
        poroda.setYarus(porodaRequestDto.getYarus());
        poroda.setPokolenie(porodaRequestDto.getPokolenie());
        poroda.setAverageAge(porodaRequestDto.getAverageAge());

        return poroda;
    }
}
