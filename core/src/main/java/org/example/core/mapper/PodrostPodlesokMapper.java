package org.example.core.mapper;


import org.example.core.dto.PodrostPodlesokDto;
import org.example.core.dto.TrialPlotDto;
import org.example.core.entity.PodrostPodlesok;
import org.example.core.entity.TrialPlot;
import org.springframework.stereotype.Component;

@Component
public class PodrostPodlesokMapper {
    public PodrostPodlesokDto toPodrostPodlesokDto(PodrostPodlesok podrostPodlesok){
        PodrostPodlesokDto podrostDto = new PodrostPodlesokDto();
        podrostDto.setId(podrostPodlesok.getId());
        podrostDto.setNomerPloshadok(podrostPodlesok.getNomerPloshadok());
        podrostDto.setPodles_height(podrostPodlesok.getPodles_height());
        podrostDto.setPodlesPoroda(podrostPodlesok.getPodlesPoroda());
        podrostDto.setPodlesQuantity(podrostPodlesok.getPodlesQuantity());
        podrostDto.setPodrostDamaged(podrostPodlesok.getPodrostDamaged());
        podrostDto.setPodrostHealthy(podrostPodlesok.getPodrostHealthy());
        podrostDto.setPodrostHeight(podrostPodlesok.getPodrostHeight());
        podrostDto.setPoroda(podrostPodlesok.getPoroda());
        TrialPlotDto trialPlotDto = new TrialPlotDto();
        trialPlotDto.setPochva(podrostPodlesok.getPlot().getPochva());
        trialPlotDto.setPositionAndRelief(podrostPodlesok.getPlot().getPositionAndRelief());
        trialPlotDto.setVidel(podrostPodlesok.getPlot().getVidel());
        trialPlotDto.setTym(podrostPodlesok.getPlot().getTym());
        trialPlotDto.setPokrov(podrostPodlesok.getPlot().getPokrov());
        trialPlotDto.setOblast(podrostPodlesok.getPlot().getOblast());
        trialPlotDto.setOsobennostiDrev(podrostPodlesok.getPlot().getOsobennostiDrev());
        trialPlotDto.setLesnichestvo(podrostPodlesok.getPlot().getLesnichestvo());
        trialPlotDto.setLeshoz(podrostPodlesok.getPlot().getLeshoz());
        trialPlotDto.setKvartal(podrostPodlesok.getPlot().getKvartal());
        trialPlotDto.setForestType(podrostPodlesok.getPlot().getForestType());
        trialPlotDto.setPochva(podrostPodlesok.getPlot().getPochva());
        trialPlotDto.setId(podrostPodlesok.getPlot().getId());
        trialPlotDto.setRayon(podrostPodlesok.getPlot().getRayon());
        trialPlotDto.setIspolnitel(podrostPodlesok.getPlot().getIspolnitel());
        trialPlotDto.setPloshadProbi(podrostPodlesok.getPlot().getPloshadProbi());
        trialPlotDto.setPlho(podrostPodlesok.getPlot().getPlho());
        podrostDto.setPlot(trialPlotDto);
        return podrostDto;
    }
    public PodrostPodlesok toPodrostPodlesok(PodrostPodlesokDto podrostPodlesokDto){
        PodrostPodlesok podrostPodlesok = new PodrostPodlesok();
        if (podrostPodlesokDto.getId()!=null){
            podrostPodlesok.setId(podrostPodlesokDto.getId());
        }
        podrostPodlesok.setNomerPloshadok(podrostPodlesokDto.getNomerPloshadok());
        podrostPodlesok.setPodles_height(podrostPodlesokDto.getPodles_height());
        podrostPodlesok.setPodlesPoroda(podrostPodlesokDto.getPodlesPoroda());
        podrostPodlesok.setPodlesQuantity(podrostPodlesokDto.getPodlesQuantity());
        podrostPodlesok.setPodrostDamaged(podrostPodlesokDto.getPodrostDamaged());
        podrostPodlesok.setPodrostHealthy(podrostPodlesokDto.getPodrostHealthy());
        podrostPodlesok.setPodrostHeight(podrostPodlesokDto.getPodrostHeight());
        podrostPodlesok.setPoroda(podrostPodlesokDto.getPoroda());
        TrialPlot trialPlot = new TrialPlot();
        trialPlot.setPochva(podrostPodlesokDto.getPlot().getPochva());
        trialPlot.setPositionAndRelief(podrostPodlesokDto.getPlot().getPositionAndRelief());
        trialPlot.setVidel(podrostPodlesokDto.getPlot().getVidel());
        trialPlot.setTym(podrostPodlesokDto.getPlot().getTym());
        trialPlot.setPokrov(podrostPodlesokDto.getPlot().getPokrov());
        trialPlot.setOblast(podrostPodlesokDto.getPlot().getOblast());
        trialPlot.setOsobennostiDrev(podrostPodlesokDto.getPlot().getOsobennostiDrev());
        trialPlot.setLesnichestvo(podrostPodlesokDto.getPlot().getLesnichestvo());
        trialPlot.setLeshoz(podrostPodlesokDto.getPlot().getLeshoz());
        trialPlot.setKvartal(podrostPodlesokDto.getPlot().getKvartal());
        trialPlot.setForestType(podrostPodlesokDto.getPlot().getForestType());
        trialPlot.setPochva(podrostPodlesokDto.getPlot().getPochva());
        trialPlot.setId(podrostPodlesokDto.getPlot().getId());
        trialPlot.setRayon(podrostPodlesokDto.getPlot().getRayon());
        trialPlot.setIspolnitel(podrostPodlesokDto.getPlot().getIspolnitel());
        trialPlot.setPloshadProbi(podrostPodlesokDto.getPlot().getPloshadProbi());
        trialPlot.setPlho(podrostPodlesokDto.getPlot().getPlho());
        podrostPodlesok.setPlot(trialPlot);
        return podrostPodlesok;
    }
}
