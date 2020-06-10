package org.example.core.service;

import org.example.core.entity.Tym;
import org.example.core.repository.TymRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TymService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeshosService.class);
    private final TymRepository tymRepository;

    @Autowired
    public TymService(TymRepository tymRepository){
        this.tymRepository=tymRepository;
    }

    public List<Tym> getAll(){
        return StreamSupport.stream(tymRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }}
