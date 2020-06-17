package org.example.core.repository;

import org.example.core.entity.Geodata;
import org.example.core.entity.Perechet;
import org.example.core.entity.Rayon;
import org.example.core.entity.TrialPlot;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GeodataRepository extends CrudRepository<Geodata, Long> , JpaSpecificationExecutor<Geodata> {
    List<Geodata> findAllByTrialPlot(Long trialPlot);
}
