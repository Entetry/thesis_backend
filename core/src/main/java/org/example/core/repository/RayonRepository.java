package org.example.core.repository;

import org.example.core.entity.Perechet;
import org.example.core.entity.Rayon;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RayonRepository extends CrudRepository<Rayon, Long> , JpaSpecificationExecutor<Rayon> {
}
