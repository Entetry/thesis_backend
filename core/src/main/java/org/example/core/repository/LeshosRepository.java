package org.example.core.repository;

import org.example.core.entity.Leshos;
import org.example.core.entity.Perechet;
import org.example.core.entity.Rayon;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface LeshosRepository extends CrudRepository<Leshos, Long> , JpaSpecificationExecutor<Leshos> {
}
