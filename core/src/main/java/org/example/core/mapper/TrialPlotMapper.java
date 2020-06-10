package org.example.core.mapper;

import dto.PodrostDto;

import org.example.core.dto.TrialPlotDto;
import org.example.core.dto.TrialPlotRequestDto;
import org.example.core.entity.HeightMeasure;
import org.example.core.entity.TrialPlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TrialPlotMapper {
    private final PorodaMapper porodaMapper;


    @Autowired
    public TrialPlotMapper(PorodaMapper porodaMapper){
        this.porodaMapper=porodaMapper;
    }
    public TrialPlotDto toTrialPlotDto(TrialPlot trialPlot){
        TrialPlotDto trialPlotDto = new TrialPlotDto();
        trialPlotDto.setRayon(trialPlot.getRayon());
        trialPlotDto.setForestType(trialPlot.getForestType());
        trialPlotDto.setId(trialPlot.getId());
        trialPlotDto.setKvartal(trialPlot.getKvartal());
        trialPlotDto.setLeshoz(trialPlot.getLeshoz());
        trialPlotDto.setLesnichestvo(trialPlot.getLesnichestvo());
        trialPlotDto.setOsobennostiDrev(trialPlot.getOsobennostiDrev());
        trialPlotDto.setOblast(trialPlot.getOblast());
        trialPlotDto.setPokrov(trialPlot.getPokrov());
        trialPlotDto.setPlho(trialPlot.getPlho());
        trialPlotDto.setPloshadProbi(trialPlot.getPloshadProbi());
        trialPlotDto.setIspolnitel(trialPlot.getIspolnitel());
        trialPlotDto.setTym(trialPlot.getTym());
        trialPlotDto.setVidel(trialPlot.getVidel());
        trialPlotDto.setPositionAndRelief(trialPlot.getPositionAndRelief());
        trialPlotDto.setPochva(trialPlot.getPochva());
        trialPlotDto.setPorodaList(trialPlot.getPorodaList().stream().map(porodaMapper::toPorodaDto).collect(Collectors.toList()));
        return trialPlotDto;
    }
    public TrialPlot toTrialPlot(TrialPlotDto trialPlotDto){
        TrialPlot trialPlot = new TrialPlot();
        trialPlot.setPochva(trialPlotDto.getPochva());
        trialPlot.setPositionAndRelief(trialPlotDto.getPositionAndRelief());
        trialPlot.setVidel(trialPlotDto.getVidel());
        trialPlot.setTym(trialPlotDto.getTym());
        trialPlot.setPokrov(trialPlotDto.getPokrov());
        trialPlot.setOblast(trialPlotDto.getOblast());
        trialPlot.setOsobennostiDrev(trialPlotDto.getOsobennostiDrev());
        trialPlot.setLesnichestvo(trialPlotDto.getLesnichestvo());
        trialPlot.setLeshoz(trialPlotDto.getLeshoz());
        trialPlot.setKvartal(trialPlotDto.getKvartal());
        trialPlot.setForestType(trialPlotDto.getForestType());
        trialPlot.setPochva(trialPlotDto.getPochva());
        trialPlot.setId(trialPlotDto.getId());
        trialPlot.setRayon(trialPlotDto.getRayon());
        trialPlot.setIspolnitel(trialPlotDto.getIspolnitel());
        trialPlot.setPloshadProbi(trialPlotDto.getPloshadProbi());
        trialPlot.setPorodaList(trialPlotDto.getPorodaList().stream().map(porodaMapper::toPoroda).collect(Collectors.toList()));
        return trialPlot;
    }
    public TrialPlot toTrialPlot(TrialPlotRequestDto trialPlotDto){
        TrialPlot trialPlot = new TrialPlot();
        trialPlot.setId(trialPlotDto.getId());
        trialPlot.setPositionAndRelief(trialPlotDto.getPositionAndRelief());
        trialPlot.setVidel(trialPlotDto.getVidel());;
        trialPlot.setOsobennostiDrev(trialPlotDto.getOsobennostiDrev());
        trialPlot.setKvartal(trialPlotDto.getKvartal());
        trialPlot.setIspolnitel(trialPlotDto.getIspolnitel());
        trialPlot.setPloshadProbi(trialPlotDto.getPloshadProbi());
        trialPlot.setPorodaList(trialPlotDto.getPorodaList().stream().map(porodaMapper::toPoroda).collect(Collectors.toList()));
        return trialPlot;
    }

}
