package org.example.backend.controller;

import org.example.core.dto.HeightMeasureDto;
import org.example.core.dto.HeightMeasureRequestDto;
import org.example.core.dto.PerechetDto;
import org.example.core.dto.PerechetRequestDto;
import org.example.core.entity.Perechet;
import org.example.core.exception.HeightMeasureNotFoundException;
import org.example.core.service.HeightMeasureService;
import org.example.core.service.PerechetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/perechet")
public class PerechetController {
    private final PerechetService perechetService;
    @Autowired
    public PerechetController(PerechetService perechetService){
        this.perechetService=perechetService;
    }

    @PostMapping
    public void create(@RequestBody List<PerechetRequestDto> perechets) {
        try {
            perechetService.create(perechets);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            perechetService.delete(id);
        } catch (HeightMeasureNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping
    public void update(@RequestBody List<PerechetRequestDto> perechetDtos) {
        try {
            perechetService.update(perechetDtos);
        } catch (HeightMeasureNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
