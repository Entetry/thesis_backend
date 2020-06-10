package org.example.core.service;

import org.example.core.entity.Geodata;
import org.example.core.entity.Leshos;
import org.example.core.exception.GeodataNotFoundException;
import org.example.core.exception.LeshosNotFoundException;
import org.example.core.repository.LeshosRepository;
import org.example.core.repository.TrialPlotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LeshosService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeshosService.class);
    private final LeshosRepository leshosRepository;
    @Autowired
    public LeshosService(LeshosRepository leshosRepository){
    this.leshosRepository=leshosRepository;
    }
    public Leshos getLeshosById(String id) {
        return leshosRepository.findById(Long.parseLong(id)).orElseThrow(LeshosNotFoundException::new);
    }
    public List<Leshos> getAllLeshoses(){
            return StreamSupport.stream(leshosRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
