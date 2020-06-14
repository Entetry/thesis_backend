package org.example.core.mapper;



import org.example.core.dto.PerechetDto;
import org.example.core.dto.PerechetRequestDto;
import org.example.core.dto.PorodaDto;
import org.example.core.entity.Perechet;
import org.example.core.entity.Poroda;
import org.springframework.stereotype.Component;

@Component
public class PerechetMapper {
    public PerechetDto toPerechetDto(Perechet perechet){
        PerechetDto perechetDto = new PerechetDto();
        perechetDto.setId(perechet.getId());
        perechetDto.setStupen(perechet.getStupen());
        perechetDto.setDelovyh(perechet.getDelovyh());
        perechetDto.setDrovyanyh(perechet.getDrovyanyh());
        perechetDto.setSuhostoynyh(perechet.getSuhostoynyh());
        PorodaDto porodaDto = new PorodaDto();
        porodaDto.setAverageAge(perechet.getPoroda().getAverageAge());
        porodaDto.setId(perechet.getPoroda().getId());
        porodaDto.setPokolenie(perechet.getPoroda().getPokolenie());
        porodaDto.setYarus(perechet.getPoroda().getYarus());
        porodaDto.setPoroda(perechet.getPoroda().getPoroda());
        perechetDto.setPoroda(porodaDto);

        return perechetDto;
    }
    public Perechet toPerechet(PerechetDto perechetDto){
        Perechet perechet = new Perechet();
        if (perechetDto.getId()!=null){
            perechet.setId(perechetDto.getId());
        }
        perechet.setStupen(perechetDto.getStupen());
        perechet.setDelovyh(perechetDto.getDelovyh());
        perechet.setDrovyanyh(perechetDto.getDrovyanyh());
        perechet.setSuhostoynyh(perechetDto.getSuhostoynyh());
        Poroda poroda = new Poroda();
        poroda.setAverageAge(perechetDto.getPoroda().getAverageAge());
        poroda.setId(perechetDto.getPoroda().getId());
        poroda.setPokolenie(perechetDto.getPoroda().getPokolenie());
        poroda.setYarus(perechetDto.getPoroda().getYarus());
        poroda.setPoroda(perechetDto.getPoroda().getPoroda());
        perechet.setPoroda(poroda);
        return perechet;
    }
    public Perechet toPerechet(PerechetRequestDto perechetDto){
        Perechet perechet = new Perechet();
        if (perechetDto.getId()!=null){
            perechet.setId(perechetDto.getId());
        }
        perechet.setStupen(perechetDto.getStupen());
        perechet.setDelovyh(perechetDto.getDelovyh());
        perechet.setDrovyanyh(perechetDto.getDrovyanyh());
        perechet.setSuhostoynyh(perechetDto.getSuhostoynyh());
        Poroda poroda = new Poroda();
        poroda.setId(perechetDto.getPorodaId());
        perechet.setPoroda(poroda);
        return perechet;
    }
}
