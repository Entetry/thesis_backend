package org.example.core.service;

import org.example.core.dto.HeightMeasureDto;
import org.example.core.dto.HeightMeasureRequestDto;
import org.example.core.dto.TrialPlotDto;
import org.example.core.entity.HeightMeasure;
import org.example.core.entity.Perechet;
import org.example.core.entity.TrialPlot;
import org.example.core.exception.HeightMeasureNotFoundException;
import org.example.core.exception.PorodaNotFoundException;
import org.example.core.exception.TrialPlotNotFoundException;
import org.example.core.mapper.HeightMeasureMapper;
import org.example.core.mapper.TrialPlotMapper;
import org.example.core.repository.HeightMeasureRepository;
import org.example.core.repository.PorodaRepository;
import org.example.core.repository.TrialPlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeightMeasureService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeightMeasureService.class);
    private final HeightMeasureRepository heightMeasureRepository;
    private final HeightMeasureMapper heightMeasureMapper;
    private final PorodaRepository porodaRepository;

    @Autowired
    public HeightMeasureService(HeightMeasureRepository heightMeasureRepository, HeightMeasureMapper heightMeasureMapper,
                                PorodaRepository porodaRepository) {
        this.heightMeasureRepository = heightMeasureRepository;
        this.heightMeasureMapper = heightMeasureMapper;
        this.porodaRepository=porodaRepository;
    }

    public HeightMeasureDto create(HeightMeasureRequestDto heightMeasureRequestDto) {
            HeightMeasure heightMeasure = heightMeasureMapper.toHeightMeasure(heightMeasureRequestDto);
            heightMeasure.setPoroda(porodaRepository.findById(heightMeasure.getPoroda().getId()).orElseThrow(PorodaNotFoundException::new));
        try {
           return heightMeasureMapper.toHeightMeasureDto(heightMeasureRepository.save(heightMeasure));
        } catch (Exception e) {
            LOGGER.error("Failed to create user", e);
            throw e;
        }
    }

    public void delete(Long id) {
        HeightMeasure heightMeasure = heightMeasureRepository.findById(id).orElseThrow(HeightMeasureNotFoundException::new);
        try {
            heightMeasureRepository.delete(heightMeasure);
        } catch (Exception e) {
            LOGGER.error("could not delete trial plot!", e);
            throw e;
        }
    }

    public void update(HeightMeasureDto heightMeasureDto) {
        HeightMeasure heightMeasure = heightMeasureRepository.findById(heightMeasureDto.getId()).orElseThrow(TrialPlotNotFoundException::new);
        try {
            heightMeasureRepository.save(heightMeasureMapper.toHeightMeasure(heightMeasureDto));
        } catch (Exception e) {
            LOGGER.error("could not update trial plot!!", e);
            throw e;
        }
    }
    public HeightMeasureDto getHeightMeasureById(String id) {
        return heightMeasureMapper.toHeightMeasureDto(heightMeasureRepository.findById(Long.parseLong(id)).orElseThrow(HeightMeasureNotFoundException::new));
    }
}
