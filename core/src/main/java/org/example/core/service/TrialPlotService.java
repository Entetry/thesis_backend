package org.example.core.service;


import org.example.core.dto.*;
import org.example.core.entity.*;
import org.example.core.exception.*;
import org.example.core.mapper.TrialPlotMapper;
import org.example.core.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeOperationsException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TrialPlotService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrialPlotService.class);
    private final TrialPlotRepository trialPlotRepository;
    private final TrialPlotMapper trialPlotMapper;
    private final QuickMath quickMath;
    private final RayonRepository rayonRepository;
    private final LesnichestvoRepository lesnichestvoRepository;
    private final OblastRepository oblastRepository;
    private final PlhoRepository  plhoRepository;
    private final LeshosRepository leshosRepository;
    private final TymRepository tymRepository;
    private final PokrovRepository pokrovRepository;
    private final ForestTypeRepository forestTypeRepository;
    private final PochvaRepository pochvaRepository;
    @Autowired
    public TrialPlotService(TrialPlotRepository trialPlotRepository,
                            TrialPlotMapper trialPlotMapper,
                            QuickMath quickMath,RayonRepository rayonRepository,
                            LesnichestvoRepository lesnichestvoRepository,
                            OblastRepository oblastRepository,
                            PlhoRepository  plhoRepository,
                            LeshosRepository leshosRepository,
                            TymRepository tymRepository,
                            PokrovRepository pokrovRepository,
                            ForestTypeRepository forestTypeRepository,
                            PochvaRepository pochvaRepository) {
        this.trialPlotRepository = trialPlotRepository;
        this.trialPlotMapper = trialPlotMapper;
        this.quickMath=quickMath;
        this.leshosRepository=leshosRepository;
        this.lesnichestvoRepository=lesnichestvoRepository;
        this.oblastRepository=oblastRepository;
        this.plhoRepository=plhoRepository;
        this.rayonRepository=rayonRepository;
        this.tymRepository=tymRepository;
        this.pochvaRepository=pochvaRepository;
        this.forestTypeRepository=forestTypeRepository;
        this.pokrovRepository=pokrovRepository;
    }

    public TrialPlotDto create(TrialPlotRequestDto trialPlotRequestDto) {
        TrialPlot trialPlot = trialPlotMapper.toTrialPlot(trialPlotRequestDto);
        trialPlot.setRayon(rayonRepository.findById(trialPlotRequestDto.getRayonId()).orElseThrow(RayonNotFoundException::new));
        trialPlot.setLeshoz(leshosRepository.findById(trialPlotRequestDto.getLeshosId()).orElseThrow(LeshosNotFoundException::new));
        trialPlot.setLesnichestvo(lesnichestvoRepository.findById(trialPlotRequestDto.getLesnichestvoId()).orElseThrow(LesnichestvoNotFoundException::new));
        trialPlot.setPlho(plhoRepository.findById(trialPlotRequestDto.getPlhoId()).orElseThrow(PlhoNotFoundException::new));
        trialPlot.setOblast(oblastRepository.findById(trialPlotRequestDto.getOblastId()).orElseThrow(OblastNotFoundException::new));
        trialPlot.setForestType(forestTypeRepository.findById(trialPlotRequestDto.getForestTypeId()).orElseThrow(ForestTypeNotFoundException::new));
        trialPlot.setPochva(pochvaRepository.findById(trialPlotRequestDto.getPochvaId()).orElseThrow(PochvaNotFoundException::new));
        trialPlot.setTym(tymRepository.findById(trialPlotRequestDto.getTymId()).orElseThrow(TymNotFoundException::new));
        trialPlot.setPokrov(pokrovRepository.findById(trialPlotRequestDto.getTymId()).orElseThrow(PochvaNotFoundException::new));
        try {
          return   trialPlotMapper.toTrialPlotDto(trialPlotRepository.save(trialPlot));
        } catch (Exception e) {
            LOGGER.error("Failed to create trial plot", e);
            throw e;
        }

    }

    public void delete(Long id) {
        TrialPlot trialPlot = trialPlotRepository.findById(id).orElseThrow(TrialPlotNotFoundException::new);
        try {
            trialPlotRepository.delete(trialPlot);
        } catch (Exception e) {
            LOGGER.error("could not delete trial plot!", e);
            throw e;
        }
    }

    public void update(TrialPlotDto trialPlotDto) {
        TrialPlot trialPlot = trialPlotRepository.findById(trialPlotDto.getId()).orElseThrow(TrialPlotNotFoundException::new);
        try {
            trialPlotRepository.save(trialPlotMapper.toTrialPlot(trialPlotDto));
        } catch (Exception e) {
            LOGGER.error("could not update trial plot!!", e);
            throw e;
        }
    }
    public TrialPlotDto getTrialPlotById(Long id) {
        return trialPlotMapper.toTrialPlotDto(trialPlotRepository.findById(id).orElseThrow(TrialPlotNotFoundException::new));
    }
    public List<TrialPlot> getAllTrialPlots(){
        return StreamSupport.stream(trialPlotRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }


    public TrialPlotDto getCalculatedTrialPlotById(Long id)   {
        TrialPlot trialPlot = trialPlotRepository.findById(id).orElseThrow(TrialPlotNotFoundException::new);
        TrialPlotDto trialPlotDto = trialPlotMapper.toTrialPlotDto(trialPlot);
        if(!trialPlotDto.getPorodaList().isEmpty())
        //Рассчитываем сумму площадей сечения и количество деревьев
        for (PorodaDto porodaDto: trialPlotDto.getPorodaList()) {
            if (!porodaDto.getPerechetList().isEmpty() && !porodaDto.getHeightMeasureList().isEmpty()) {
                int treeQuantity = 0;
                double summPlSech = 0.0;
                double averageDiameter = 0.0;
                double stock = 0.0;
               // porodaDto.setAverageHeight(quickMath.calculateAverageHeigh(porodaDto.getHeightMeasureList()));
                for (PerechetDto perechetDto : porodaDto.getPerechetList()) {
                    summPlSech += perechetDto.getStupen() * 100 * Math.PI * perechetDto.getDelovyh() * perechetDto.getDrovyanyh() / 4;
                    treeQuantity += perechetDto.getDelovyh() + perechetDto.getDrovyanyh();
                }
                porodaDto.setSummPloshSech(summPlSech);
                //считаем средний диаметр
                porodaDto.setAverageDiameter(200 * Math.pow(porodaDto.getSummPloshSech() / Math.PI, 2));
                //porodaDto.setAverageZapas(quickMath.CalculateZapas(porodaDto.getPerechetList(),porodaDto.getHeightMeasureList()));
            }
        }
        return trialPlotDto;
    }


    //    public TrialPlotDto getTrialPlot(Long id) {
//        TrialPlot trialPlot = trialPlotRepository.findById(id).orElseThrow(TrialPlotNotFoundException::new);
//        Double ploshad = Math.PI * trialPlot.getPorodaList().get(1).getPerechetList().get(1).getStupen() / 4;
//        List<Double> doubles = new ArrayList<>();
//        double summPloshSech = 0.00;
//        double averagePloshSech = 0.00;
//        double averageDiameter = 0.00;
//        int quantity = 0;
//        double averageHeight = 0.00;
//        Double zapas = 0.00;
//        Double a1 = 0.00;
//        for (Poroda poroda : trialPlot.getPorodaList()) {
//            for (Perechet perechet : poroda.getPerechetList()) {
//                summPloshSech = summPloshSech + Math.pow(perechet.getStupen(), 2) * Math.PI * perechet.getDelovyh() / 4;
//                quantity = quantity + perechet.getDelovyh();
//            }
//            averagePloshSech = summPloshSech / quantity;
//            averageDiameter = 200 * Math.sqrt(averagePloshSech / Math.PI);
//            for (HeightMeasure heightMeasure : poroda.getHeightMeasureList()) {
//                averageHeight = averageHeight + Math.pow(heightMeasure.getDiameter(), 2) * Math.PI * heightMeasure.getHeight() / 4;
//                switch (poroda.getPoroda()) {
//                    case ("Береза"):
//                        a1 = 0.697597;
//                        break;
//                    case ("Сосна"):
//                        a1 = 0.734917;
//                        break;
//                    case ("Ель"):
//                        a1 = 0.637832;
//                        break;
//                    case ("Ольха черная"):
//                        a1 = 0.724094;
//                        break;
//                    case ("Осина"):
//                        a1 = 0.610513;
//                        break;
//                    case ("Дуб"):
//                        a1 = 0.661662;
//                        break;
//                    default:
//                        a1 = 0.0;
//                        break;
//                }
//
//                zapas += 0.0000785398163 * Math.pow(heightMeasure.getDiameter(), 2) * Math.pow(heightMeasure.getHeight(), (2 * a1 + 1)) / ((2 * a1 + 1) * Math.pow((heightMeasure.getHeight() - 1.3), (2 * a1)));
//            }
//        }
//        averageHeight = averageHeight / summPloshSech;
//    }
}

