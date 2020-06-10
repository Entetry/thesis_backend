package org.example.core.repository;

import org.example.core.entity.HeightMeasure;
import org.example.core.entity.Poroda;
import org.springframework.data.repository.CrudRepository;

public interface PorodaRepository extends CrudRepository<Poroda, Long> {
}
