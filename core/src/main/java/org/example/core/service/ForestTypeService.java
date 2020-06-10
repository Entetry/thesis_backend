package org.example.core.service;

import org.example.core.entity.ForestType;
import org.example.core.entity.Plho;
import org.example.core.exception.PlhoNotFoundException;
import org.example.core.repository.ForestTypeRepository;
import org.example.core.repository.PlhoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ForestTypeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeshosService.class);
    private final ForestTypeRepository forestTypeRepository;

    @Autowired
    public ForestTypeService(ForestTypeRepository forestTypeRepository){
        this.forestTypeRepository=forestTypeRepository;
    }

    public List<ForestType> getAll(){
        return StreamSupport.stream(forestTypeRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
