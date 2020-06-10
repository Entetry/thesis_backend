package org.example.core.service;

import org.example.core.entity.Pokrov;
import org.example.core.repository.PokrovRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PokrovService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeshosService.class);
    private final PokrovRepository pokrovRepository;

    @Autowired
    public PokrovService(PokrovRepository pokrovRepository){
        this.pokrovRepository=pokrovRepository;
    }

    public List<Pokrov> getAll(){
        return StreamSupport.stream(pokrovRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
