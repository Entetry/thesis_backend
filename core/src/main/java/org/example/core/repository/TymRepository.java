package org.example.core.repository;

import org.example.core.entity.TrialPlot;
import org.example.core.entity.Tym;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TymRepository extends CrudRepository<Tym, Long> {
}
