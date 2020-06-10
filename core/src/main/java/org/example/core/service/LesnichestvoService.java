package org.example.core.service;

import org.example.core.entity.Leshos;
import org.example.core.entity.Lesnichestvo;
import org.example.core.exception.LeshosNotFoundException;
import org.example.core.exception.LesnichestvoNotFoundException;
import org.example.core.repository.LeshosRepository;
import org.example.core.repository.LesnichestvoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LesnichestvoService  {
    private static final Logger LOGGER = LoggerFactory.getLogger(LesnichestvoService.class);
    private final LesnichestvoRepository lesnichestvoRepository;
    @Autowired
    public LesnichestvoService(LesnichestvoRepository lesnichestvoRepository){
        this.lesnichestvoRepository=lesnichestvoRepository;
    }
    public Lesnichestvo getLesnichestvoById(String id) {
        return lesnichestvoRepository.findById(Long.parseLong(id)).orElseThrow(LesnichestvoNotFoundException::new);
    }
    public List<Lesnichestvo> getAllLesnichestvos(){
        return StreamSupport.stream(lesnichestvoRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
