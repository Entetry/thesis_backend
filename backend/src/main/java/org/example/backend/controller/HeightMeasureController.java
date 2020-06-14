package org.example.backend.controller;

import org.example.core.dto.HeightMeasureDto;
import org.example.core.dto.HeightMeasureRequestDto;
import org.example.core.entity.Geodata;
import org.example.core.entity.HeightMeasure;
import org.example.core.exception.GeodataNotFoundException;
import org.example.core.exception.HeightMeasureNotFoundException;
import org.example.core.service.GeodataService;
import org.example.core.service.HeightMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/heightmeasure")
public class HeightMeasureController {
    private final HeightMeasureService heightMeasureService;
    @Autowired
    public HeightMeasureController(HeightMeasureService heightMeasureService){
        this.heightMeasureService=heightMeasureService;
    }

    @PostMapping
    public HeightMeasureDto create(@RequestBody HeightMeasureRequestDto heightMeasureRequestDto) {
        try {
           return heightMeasureService.create(heightMeasureRequestDto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            heightMeasureService.delete(id);
        } catch (HeightMeasureNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping
    public void update(@RequestBody HeightMeasureDto heightMeasureDto) {
        try {
            heightMeasureService.update(heightMeasureDto);
        } catch (HeightMeasureNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
