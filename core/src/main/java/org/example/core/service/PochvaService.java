package org.example.core.service;

import org.example.core.entity.Pochva;
import org.example.core.repository.PochvaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PochvaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeshosService.class);
    private final PochvaRepository pochvaRepository;

    @Autowired
    public PochvaService(PochvaRepository pochvaRepository){
        this.pochvaRepository=pochvaRepository;
    }

    public List<Pochva> getAll(){
        return StreamSupport.stream(pochvaRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
