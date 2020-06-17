package org.example.core.service;


import org.apache.commons.math3.util.Precision;
import org.example.core.dto.*;
import org.example.core.entity.*;
import org.example.core.exception.*;
import org.example.core.mapper.TrialPlotMapper;
import org.example.core.repository.*;
import org.example.core.search.TrialPlotSpecification;
import org.example.core.search.TrialPlotSpecificationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private final PorodaInfoRepository porodaInfoRepository;
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
                            PochvaRepository pochvaRepository,
                            PorodaInfoRepository porodaInfoRepository) {
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
        this.porodaInfoRepository=porodaInfoRepository;
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
        trialPlot.setPorodaInfo(porodaInfoRepository.findById((trialPlotRequestDto.getPorodaId())).orElseThrow(PorodaInfoNotFoundException::new));
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
        TrialPlot trialPlot1 = trialPlotMapper.toTrialPlot(trialPlotDto);
        trialPlot1.setGeodatas(trialPlot.getGeodatas());
        trialPlot1.setPorodaList(trialPlot.getPorodaList());

        try {
            trialPlotRepository.save(trialPlot1);
        } catch (Exception e) {
            LOGGER.error("could not update trial plot!!", e);
            throw e;
        }
    }
    public TrialPlotDto getTrialPlotById(Long id) {
        return trialPlotMapper.toTrialPlotDto(trialPlotRepository.findById(id).orElseThrow(TrialPlotNotFoundException::new));
    }
    public List<TrialPlotDto> search(@RequestParam(value = "search") String search) {
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        List<TrialPlotSpecification> predicates = new ArrayList<>();
        Specification<TrialPlot> spec = null;
        while (matcher.find()) {
            TrialPlotSpecificationBuilder builder = new TrialPlotSpecificationBuilder();
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            if (spec == null ) {
                spec = builder.build();
            } else {
                spec = spec.and(builder.build());
            }
        }

       // Specification<TrialPlot> spec = predicates.stream().collect(Collectors.mapping(v -> criteriaBuilder.and(v)));
        return trialPlotRepository.findAll(spec).stream().map(trialPlotMapper::toTrialPlotDto).collect(Collectors.toList());
    }
    public List<TrialPlot> getAllTrialPlots(){
        return StreamSupport.stream(trialPlotRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
    public TrialPlotDto  getCalculatedTrialPlotById(Long id){
        TrialPlot trialPlot = trialPlotRepository.findById(id).orElseThrow(TrialPlotNotFoundException::new);
        TrialPlotDto trialPlotDto = trialPlotMapper.toTrialPlotDto(trialPlot);
        if(!trialPlotDto.getPorodaList().isEmpty()){
            double totalZapas=0.0;
            for (PorodaDto porodaDto: trialPlotDto.getPorodaList()) {
                double sumPlSech = 0.0,averageHeight=0.0,averageZapas=0.0,plPoperSechForOneTree=0.0,averageDiameter=0.0, zapasDel =0.0, zapasSuh=0.0;
                int amountDelovih=0,totalAmount =0,amountSuhostoi=0;
                double [][] coefHeightMatrix;
                if (!porodaDto.getPerechetList().isEmpty() && !porodaDto.getHeightMeasureList().isEmpty()) {
                    coefHeightMatrix=quickMath.calculateCoefHeightMatrix(porodaDto.getHeightMeasureList());
                    //Считаем высоты для графика и среднюю высоту
                    for (HeightMeasureDto heightMeasureDto: porodaDto.getHeightMeasureList()){
                        heightMeasureDto.setDependentHeight(coefHeightMatrix[0][0]*Math.pow(heightMeasureDto.getDiameter(),2)+coefHeightMatrix[1][0]*heightMeasureDto.getHeight()+coefHeightMatrix[2][0]);
                        averageHeight+=heightMeasureDto.getDependentHeight()/porodaDto.getHeightMeasureList().size();
                    }
                    porodaDto.setAverageHeight(Precision.round(averageHeight,2));
                    //Считаем запас( Для этого вычисляем высоты по ступеням толщины, считаем обьём и потом уже запас)
                    //ВОЗМОЖНО НУЖНО БУДЕТ ДИАМЕТР ПЕРЕВЕСТИ В САНЦИМЕТРЫ
                    for(PerechetDto perechetDto : porodaDto.getPerechetList()){
                        double height= (coefHeightMatrix[0][0]*Math.pow(perechetDto.getStupen(),2)+coefHeightMatrix[1][0]*(perechetDto.getStupen())+coefHeightMatrix[2][0]);
                        averageZapas+=quickMath.calculateTreeVolume(perechetDto,height)*(perechetDto.getDelovyh()+perechetDto.getDrovyanyh());
                        zapasDel+=quickMath.calculateTreeVolume(perechetDto,height)*perechetDto.getDelovyh();
                        zapasSuh+=quickMath.calculateTreeVolume(perechetDto,height)*perechetDto.getSuhostoynyh();
                        //Рассчитываем сумму площадей сечения и количество деревьев
                        sumPlSech+=(Math.pow(perechetDto.getStupen()/100,2)  * Math.PI * (perechetDto.getDelovyh() + perechetDto.getDrovyanyh())) / 4;
                        amountDelovih+=perechetDto.getDelovyh();
                        amountSuhostoi+=perechetDto.getSuhostoynyh();
                        totalAmount+=perechetDto.getDelovyh()+perechetDto.getDrovyanyh();
                        perechetDto.setHeight(height);
                    }
                    porodaDto.setTotalAmount(totalAmount);
                    double amountdelll = amountDelovih/trialPlotDto.getPloshadProbi();
                    porodaDto.setAmoutDelovih((int)amountdelll);
                    porodaDto.setSummPloshSech(Precision.round(sumPlSech   ,2));
                    porodaDto.setSuhStock(Precision.round(zapasSuh/trialPlotDto.getPloshadProbi(),2));
                    porodaDto.setDelStock(Precision.round(zapasDel/trialPlotDto.getPloshadProbi(),2));
                    porodaDto.setRastStock(Precision.round(averageZapas/trialPlotDto.getPloshadProbi(),2));
                    //Считаем средний диаметр (
                    porodaDto.setAverageDiameter(Precision.round(200 * Math.sqrt((porodaDto.getSummPloshSech()) / (Math.PI*totalAmount)),2));
                    porodaDto.setSummPloshSech(Precision.round(sumPlSech/trialPlotDto.getPloshadProbi(),2));
                    //Считаем полноту
                    porodaDto.setPolnota(Precision.round((porodaDto.getSummPloshSech()/quickMath.calculateNormalSumPlSech(porodaDto))/0.3,2));
                    //Считаем класс бонитета
                    porodaDto.setBonitetClass(quickMath.calculateBonitetClass(porodaDto));
                    //Определяем процент выхода деловой древесины ВОЗМОЖНО НЕ ПРАВИЛЬНО процент выхода по запасу
                    //Считаем общий запас
                    totalZapas+=porodaDto.getRastStock();
                }
            }
                //Определяем коэфицент состава для каждой породы по запасу получ запас на порды делим на общий запас
            for (PorodaDto porodaDto:trialPlotDto.getPorodaList()
                 ) {
                if (!porodaDto.getPerechetList().isEmpty() && !porodaDto.getHeightMeasureList().isEmpty()) {
                    double koef = 10 *porodaDto.getRastStock()/totalZapas;
                    porodaDto.setYieldPercentage(Precision.round(100*porodaDto.getDelStock()/porodaDto.getRastStock(),0  ));
                    porodaDto.setSostavCoeficient( String.valueOf(Math.round(koef)) + porodaDto.getPoroda().getName().charAt(0));}
            }

        }

    return trialPlotDto;
    }



}

