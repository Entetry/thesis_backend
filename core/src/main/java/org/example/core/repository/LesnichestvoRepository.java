package org.example.core.repository;

import org.example.core.entity.Lesnichestvo;
import org.example.core.entity.Perechet;
import org.example.core.entity.Rayon;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface LesnichestvoRepository extends CrudRepository<Lesnichestvo, Long>, JpaSpecificationExecutor<Lesnichestvo> {
}
