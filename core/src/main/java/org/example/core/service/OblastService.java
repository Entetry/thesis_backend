package org.example.core.service;

import org.example.core.entity.Leshos;
import org.example.core.entity.Oblast;
import org.example.core.exception.LeshosNotFoundException;
import org.example.core.exception.OblastNotFoundException;
import org.example.core.repository.LeshosRepository;
import org.example.core.repository.OblastRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OblastService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OblastService.class);
    private final OblastRepository oblastRepository;
    @Autowired
    public OblastService(OblastRepository oblastRepository){
        this.oblastRepository=oblastRepository;
    }
    public Oblast getOblastById(String id) {
        return oblastRepository.findById(Long.parseLong(id)).orElseThrow(OblastNotFoundException::new);
    }
    public List<Oblast> getAllOblasts(){
        return StreamSupport.stream(oblastRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
