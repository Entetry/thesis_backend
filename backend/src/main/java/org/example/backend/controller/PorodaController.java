package org.example.backend.controller;

import org.example.core.dto.PorodaDto;
import org.example.core.dto.PorodaRequestDto;
import org.example.core.entity.Geodata;
import org.example.core.exception.GeodataNotFoundException;
import org.example.core.exception.PorodaNotFoundException;
import org.example.core.service.GeodataService;
import org.example.core.service.PorodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/poroda")
public class PorodaController {
    private final PorodaService porodaService;
    @Autowired
    public PorodaController(PorodaService porodaService){
        this.porodaService=porodaService;
    }

    @PostMapping
    public void create(@RequestBody PorodaRequestDto porodaDto) {
        try {
            porodaService.create(porodaDto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            porodaService.delete(id);
        } catch (PorodaNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping
    public void update(@RequestBody PorodaDto porodaDto) {
        try {
            porodaService.update(porodaDto);
        } catch (GeodataNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
