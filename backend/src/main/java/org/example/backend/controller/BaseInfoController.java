package org.example.backend.controller;

import org.example.core.entity.*;
import org.example.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/baseInfo")
public class BaseInfoController {
    private final LeshosService leshosService;
    private final LesnichestvoService lesnichestvoService;
    private final OblastService oblastService;
    private final PlhoService plhoService;
    private final RayonService rayonService;
    private final TymService tymService;
    private final PochvaService pochvaService;
    private final ForestTypeService forestTypeService;
    private final PokrovService pokrovService;
    private final PorodaInfoService porodaInfoService;

    @Autowired
    public BaseInfoController(
        LeshosService leshosService,
        LesnichestvoService lesnichestvoService,
        OblastService oblastService,
        PlhoService plhoService,
        RayonService rayonService,
        TymService tymService,
        PochvaService pochvaService,
        ForestTypeService forestTypeService,
        PokrovService pokrovService,
        PorodaInfoService porodaInfoService)
    {
        this.leshosService = leshosService;
        this.lesnichestvoService = lesnichestvoService;
        this.oblastService = oblastService;
        this.plhoService = plhoService;
        this.rayonService = rayonService;
        this.tymService = tymService;
        this.pochvaService = pochvaService;
        this.forestTypeService = forestTypeService;
        this.pokrovService = pokrovService;
        this.porodaInfoService=porodaInfoService;
    }
    @GetMapping("/lesnichestvas")
    @ResponseBody
    public List<Lesnichestvo> getAllLesnichestvos(){
        return lesnichestvoService.getAllLesnichestvos();
    }
    @GetMapping("/lesHoses")
    @ResponseBody
    public List<Leshos> getAllLeshoses(){
        return leshosService.getAllLeshoses();
    }
    @GetMapping("/regions")
    @ResponseBody
    public List<Oblast> getAllOblasts(){
        return oblastService.getAllOblasts();
    }
    @GetMapping("/plhos")
    @ResponseBody
    public List<Plho> getAllPlhos(){
        return plhoService.getAllPlhos();
    }
    @GetMapping("/rayons")
    @ResponseBody
    public List<Rayon> getAllRayones(){
        List<Rayon> rayons = rayonService.getAllRayones();
        return rayons;
    }
    @GetMapping("/rayons/{id}")
    public Rayon getById(@PathVariable String id){
        return rayonService.getRayonById(id);
    }

    @GetMapping("/forestTypes")
    public List<ForestType> getAll(){
        return forestTypeService.getAll();
    }

    @GetMapping("/tyms")
    public List<Tym> getAllTyms(){
        return tymService.getAll();
    }

    @GetMapping("/pochvas")
    public List<Pochva> getAllPochvas(){
        return pochvaService.getAll();
    }

    @GetMapping("/pokrovs")
    public List<Pokrov> getAllPokrovs(){
        return pokrovService.getAll();
    }
    @GetMapping("/porodaInfo")
    public List<PorodaInfo> getAllPorodas(){return porodaInfoService.getAll();}
}
