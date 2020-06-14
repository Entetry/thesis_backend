package org.example.core.service;

import org.example.core.dto.PerechetRequestDto;
import org.example.core.dto.PodrostPodlesokDto;
import org.example.core.dto.PorodaDto;
import org.example.core.dto.PorodaRequestDto;
import org.example.core.entity.Perechet;
import org.example.core.entity.PodrostPodlesok;
import org.example.core.entity.Poroda;
import org.example.core.exception.HeightMeasureNotFoundException;
import org.example.core.exception.PodrostPodlesokNotFoundException;
import org.example.core.exception.PorodaNotFoundException;
import org.example.core.exception.TrialPlotNotFoundException;
import org.example.core.mapper.PodrostPodlesokMapper;
import org.example.core.mapper.PorodaMapper;
import org.example.core.repository.PodrostPodlesokRepository;
import org.example.core.repository.PorodaInfoRepository;
import org.example.core.repository.PorodaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PodrostPodlesokService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PorodaService.class);
    private final PodrostPodlesokRepository podrostPodlesokRepository;
    private final PorodaInfoRepository porodaInfoRepository;
    private final PodrostPodlesokMapper podrostPodlesokMapper;

    @Autowired
    public PodrostPodlesokService(PodrostPodlesokRepository podrostPodlesokRepository,PorodaInfoRepository porodaInfoRepository,PodrostPodlesokMapper podrostPodlesokMapper) {
        this.podrostPodlesokMapper = podrostPodlesokMapper;
        this.podrostPodlesokRepository = podrostPodlesokRepository;
        this.porodaInfoRepository=porodaInfoRepository;
    }

    public void create(List<PodrostPodlesokDto> podrostPodlesokDtoList) {
        List<PodrostPodlesok> podrostPodlesokList = podrostPodlesokDtoList.stream().map(podrostPodlesokMapper::toPodrostPodlesok).collect(Collectors.toList());
        for (PodrostPodlesok podrostPodlesok : podrostPodlesokList) {
            podrostPodlesok.setPoroda(porodaInfoRepository.findById(podrostPodlesok.getPoroda().getId()).orElseThrow(PorodaNotFoundException::new));
        }
        try {
            podrostPodlesokRepository.saveAll(podrostPodlesokList);
        } catch (Exception e) {
            LOGGER.error("Failed to create poroda", e);
            throw e;
        }
    }

    public void delete(Long id) {
        PodrostPodlesok podrostPodlesok = podrostPodlesokRepository.findById(id).orElseThrow(PodrostPodlesokNotFoundException::new);
        try {
            podrostPodlesokRepository.delete(podrostPodlesok);
        } catch (Exception e) {
            LOGGER.error("could not delete poroda!", e);
            throw e;
        }
    }

    public void update(PodrostPodlesokDto podrostPodlesokDto) {
        PodrostPodlesok podrostPodlesok = podrostPodlesokRepository.findById(podrostPodlesokDto.getId()).orElseThrow(PodrostPodlesokNotFoundException::new);
        try {
            podrostPodlesokRepository.save(podrostPodlesokMapper.toPodrostPodlesok(podrostPodlesokDto));
        } catch (Exception e) {
            LOGGER.error("could not update poroda!!", e);
            throw e;
        }
    }
    public PodrostPodlesokDto getPodrostPodlesokById(String id) {
        return podrostPodlesokMapper.toPodrostPodlesokDto(podrostPodlesokRepository.findById(Long.valueOf(id)).orElseThrow(PorodaNotFoundException::new));
    }
}
