package org.example.core.repository;

import org.example.core.entity.Geodata;
import org.example.core.entity.Perechet;
import org.example.core.entity.Rayon;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface GeodataRepository extends CrudRepository<Geodata, Long> , JpaSpecificationExecutor<Geodata> {
}
