package org.example.core.repository;

import org.example.core.entity.HeightMeasure;
import org.example.core.entity.Poroda;
import org.example.core.entity.Rayon;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface PorodaRepository extends CrudRepository<Poroda, Long>, JpaSpecificationExecutor<Poroda> {
}
