package org.example.core.service;

import org.example.core.dto.TrialPlotDto;
import org.example.core.entity.Geodata;
import org.example.core.entity.TrialPlot;
import org.example.core.exception.GeodataNotFoundException;
import org.example.core.exception.TrialPlotNotFoundException;
import org.example.core.repository.GeodataRepository;
import org.example.core.repository.TrialPlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeodataService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeodataService.class);
    private final GeodataRepository geodataRepository;
    @Autowired
    public GeodataService(GeodataRepository geodataRepository){
     this.geodataRepository=geodataRepository;
    }
    public void create(Geodata geodata) {
        try {
            geodataRepository.save(geodata);
        } catch (Exception e) {
            LOGGER.error("Failed to create trial plot", e);
            throw e;
        }
    }

    public void delete(Long id) {
        Geodata geodata = geodataRepository.findById(id).orElseThrow(GeodataNotFoundException::new);
        try {
            geodataRepository.delete(geodata);
        } catch (Exception e) {
            LOGGER.error("could not delete geodata!", e);
            throw e;
        }
    }

    public void update(Geodata geodata) {

        Geodata geodata1 = geodataRepository.findById(geodata.getId()).orElseThrow(TrialPlotNotFoundException::new);
        try {
            geodataRepository.save(geodata);
        } catch (Exception e) {
            LOGGER.error("could not update geodata!!", e);
            throw e;
        }
    }
    public Geodata getTrialPlotById(String id) {
        return geodataRepository.findById(Long.parseLong(id)).orElseThrow(GeodataNotFoundException::new);
    }
}
