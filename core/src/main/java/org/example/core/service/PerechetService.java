package org.example.core.service;

import org.example.core.dto.HeightMeasureDto;
import org.example.core.dto.PerechetDto;
import org.example.core.dto.PerechetRequestDto;
import org.example.core.entity.HeightMeasure;
import org.example.core.entity.Perechet;
import org.example.core.exception.HeightMeasureNotFoundException;
import org.example.core.exception.PerechetNotFoundException;
import org.example.core.exception.PorodaNotFoundException;
import org.example.core.exception.TrialPlotNotFoundException;
import org.example.core.mapper.HeightMeasureMapper;
import org.example.core.mapper.PerechetMapper;
import org.example.core.repository.HeightMeasureRepository;
import org.example.core.repository.PerechetRepository;
import org.example.core.repository.PorodaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerechetService  {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeightMeasureService.class);
    private final PerechetRepository perechetRepository;
    private final PerechetMapper perechetMapper;
    private final PorodaRepository porodaRepository;

    @Autowired
    public PerechetService(PerechetRepository perechetRepository, PerechetMapper perechetMapper,PorodaRepository porodaRepository) {
        this.perechetRepository = perechetRepository;
        this.perechetMapper = perechetMapper;
        this.porodaRepository=porodaRepository;
    }

    public void create(List<PerechetRequestDto> perechetDto) {
        List<Perechet> perechetList = perechetDto.stream().map(perechetMapper::toPerechet).collect(Collectors.toList());
        for (Perechet perechet : perechetList) {
            perechet.setPoroda(porodaRepository.findById(perechet.getPoroda().getId()).orElseThrow(PorodaNotFoundException::new));
        }
        try {
            perechetRepository.saveAll(perechetList);
        } catch (Exception e) {
            LOGGER.error("Failed to create user", e);
            throw e;
        }
    }

    public void delete(Long id) {
        Perechet perechet = perechetRepository.findById(id).orElseThrow(PerechetNotFoundException::new);
        try {
            perechetRepository.delete(perechet);
        } catch (Exception e) {
            LOGGER.error("could not delete trial plot!", e);
            throw e;
        }
    }

    public void update(List<PerechetRequestDto> perechetDto) {
        perechetDto.stream().forEach(perechetRequestDto -> perechetRepository.findById(perechetRequestDto.getId()).orElseThrow(PerechetNotFoundException::new));
        try {
            perechetRepository.saveAll(perechetDto.stream().map(perechetMapper::toPerechet).collect(Collectors.toList()));
        } catch (Exception e) {
            LOGGER.error("could not update trial plot!!", e);
            throw e;
        }
    }
    public PerechetDto getPerechetById(String id) {
        return perechetMapper.toPerechetDto(perechetRepository.findById(Long.parseLong(id)).orElseThrow(PerechetNotFoundException::new));
    }

}
