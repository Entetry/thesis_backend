package org.example.core.service;

import org.example.core.entity.Leshos;
import org.example.core.entity.Oblast;
import org.example.core.entity.Rayon;
import org.example.core.exception.OblastNotFoundException;
import org.example.core.exception.RayonNotFoundException;
import org.example.core.repository.OblastRepository;
import org.example.core.repository.RayonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RayonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OblastService.class);
    private final RayonRepository rayonRepository;
    @Autowired
    public RayonService(RayonRepository rayonRepository){
        this.rayonRepository=rayonRepository;
    }
    public Rayon getRayonById(String id) {
        return rayonRepository.findById(Long.parseLong(id)).orElseThrow(RayonNotFoundException::new);
    }
    public List<Rayon> getAllRayones(){
        return StreamSupport.stream(rayonRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}