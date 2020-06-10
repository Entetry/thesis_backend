package org.example.core.service;

import org.example.core.entity.Leshos;
import org.example.core.entity.Plho;
import org.example.core.exception.LeshosNotFoundException;
import org.example.core.exception.PlhoNotFoundException;
import org.example.core.repository.LeshosRepository;
import org.example.core.repository.PlhoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlhoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeshosService.class);
    private final PlhoRepository plhoRepository;
    @Autowired
    public PlhoService(PlhoRepository plhoRepository){
        this.plhoRepository=plhoRepository;
    }
    public Plho getPlhoById(String id) {
        return plhoRepository.findById(Long.parseLong(id)).orElseThrow(PlhoNotFoundException::new);
    }
    public List<Plho> getAllPlhos(){
        return StreamSupport.stream(plhoRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
