package org.example.core.service;

import org.example.core.dto.HeightMeasureDto;
import org.example.core.dto.PorodaDto;
import org.example.core.dto.PorodaRequestDto;
import org.example.core.entity.HeightMeasure;
import org.example.core.entity.Poroda;
import org.example.core.exception.HeightMeasureNotFoundException;
import org.example.core.exception.PorodaNotFoundException;
import org.example.core.exception.TrialPlotNotFoundException;
import org.example.core.mapper.HeightMeasureMapper;
import org.example.core.mapper.PorodaMapper;
import org.example.core.repository.HeightMeasureRepository;
import org.example.core.repository.PorodaInfoRepository;
import org.example.core.repository.PorodaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PorodaService  {
    private static final Logger LOGGER = LoggerFactory.getLogger(PorodaService.class);
    private final PorodaRepository porodaRepository;
    private final PorodaMapper porodaMapper;
    private final PorodaInfoRepository porodaInfoRepository;

    @Autowired
    public PorodaService(PorodaRepository porodaRepository, PorodaMapper porodaMapper,PorodaInfoRepository porodaInfoRepository) {
        this.porodaRepository = porodaRepository;
        this.porodaMapper = porodaMapper;
        this.porodaInfoRepository=porodaInfoRepository;
    }

    public void create(PorodaRequestDto porodaDto) {
        Poroda poroda = porodaMapper.toPoroda(porodaDto);
        poroda.setPoroda(porodaInfoRepository.findById(porodaDto.getPorodaId()).orElseThrow(PorodaNotFoundException::new));
        try {
            porodaRepository.save(poroda);
        } catch (Exception e) {
            LOGGER.error("Failed to create poroda", e);
            throw e;
        }
    }

    public void delete(Long id) {
        Poroda poroda = porodaRepository.findById(id).orElseThrow(HeightMeasureNotFoundException::new);
        try {
            porodaRepository.delete(poroda);
        } catch (Exception e) {
            LOGGER.error("could not delete poroda!", e);
            throw e;
        }
    }

    public void update(PorodaDto porodaDto) {
        Poroda poroda = porodaRepository.findById(porodaDto.getId()).orElseThrow(TrialPlotNotFoundException::new);
        try {
            porodaRepository.save(porodaMapper.toPoroda(porodaDto));
        } catch (Exception e) {
            LOGGER.error("could not update poroda!!", e);
            throw e;
        }
    }
    public PorodaDto getPorodaById(String id) {
        return porodaMapper.toPorodaDto(porodaRepository.findById(Long.parseLong(id)).orElseThrow(PorodaNotFoundException::new));
    }
}
