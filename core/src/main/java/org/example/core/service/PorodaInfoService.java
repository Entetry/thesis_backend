package org.example.core.service;

import org.example.core.entity.Pokrov;
import org.example.core.entity.Poroda;
import org.example.core.entity.PorodaInfo;
import org.example.core.repository.PokrovRepository;
import org.example.core.repository.PorodaInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PorodaInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeshosService.class);
    private final PorodaInfoRepository porodaInfoRepository;

    @Autowired
    public PorodaInfoService(PorodaInfoRepository porodaInfoRepository){
        this.porodaInfoRepository=porodaInfoRepository;
    }

    public List<PorodaInfo> getAll(){
        return StreamSupport.stream(porodaInfoRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
