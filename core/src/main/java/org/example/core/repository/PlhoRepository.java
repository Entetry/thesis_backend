package org.example.core.repository;

import org.example.core.entity.Plho;
import org.example.core.entity.Rayon;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface PlhoRepository extends CrudRepository<Plho, Long> , JpaSpecificationExecutor<Plho> {

}
