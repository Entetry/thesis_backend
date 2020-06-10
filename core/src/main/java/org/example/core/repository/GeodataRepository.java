package org.example.core.repository;

import org.example.core.entity.Geodata;
import org.example.core.entity.Perechet;
import org.springframework.data.repository.CrudRepository;

public interface GeodataRepository extends CrudRepository<Geodata, Long> {
}
