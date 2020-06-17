package org.example.backend.controller;


import org.example.core.dto.TrialPlotDto;
import org.example.core.dto.TrialPlotRequestDto;
import org.example.core.exception.TrialPlotNotFoundException;
import org.example.core.service.TrialPlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trialplots")
public class TrialPlotController {
    private final TrialPlotService trialPlotService;

    @Autowired
    public TrialPlotController(TrialPlotService trialPlotService){
        this.trialPlotService=trialPlotService;
    }

    @PostMapping
    public TrialPlotDto create(@RequestBody TrialPlotRequestDto trialPlotRequestDto) {
        try {
            return trialPlotService.create(trialPlotRequestDto);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
    @GetMapping("/{id}")
    public TrialPlotDto getTrialPlotById(@PathVariable Long id){
        try {
            return trialPlotService.getTrialPlotById(id);
        }
        catch (TrialPlotNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
    @GetMapping("/{id}/calculated")
    public TrialPlotDto getCalculatedTrialPlotById(@PathVariable Long id){
        try {
            return trialPlotService.getCalculatedTrialPlotById(id);
        }
        catch (TrialPlotNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            trialPlotService.delete(id);
        } catch (TrialPlotNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping
    public void update(@RequestBody TrialPlotDto trialPlotDto) {
        try {
            trialPlotService.update(trialPlotDto);
        } catch (TrialPlotNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exc.getMessage(), exc);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<TrialPlotDto> search(@RequestParam(value = "search") String search) {
        List<TrialPlotDto> dto =  trialPlotService.search(search);
        return dto;
    }
}
