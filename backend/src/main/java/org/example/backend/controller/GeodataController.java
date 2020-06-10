package org.example.backend.controller;

import org.example.core.dto.TrialPlotDto;
import org.example.core.entity.Geodata;
import org.example.core.exception.GeodataNotFoundException;
import org.example.core.exception.TrialPlotNotFoundException;
import org.example.core.service.GeodataService;
import org.example.core.service.TrialPlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/geodata")
public class GeodataController {
    private final GeodataService geodataService;
    @Autowired
    public GeodataController(GeodataService geodataService){
        this.geodataService=geodataService;
    }

    @PostMapping
    public void create(@RequestBody Geodata geodata) {
        try {
            geodataService.create(geodata);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            geodataService.delete(id);
        } catch (GeodataNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping
    public void update(@RequestBody Geodata geodata) {
        try {
            geodataService.update(geodata);
        } catch (GeodataNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
