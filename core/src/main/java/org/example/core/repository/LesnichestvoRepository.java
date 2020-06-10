package org.example.core.repository;

import org.example.core.entity.Lesnichestvo;
import org.example.core.entity.Perechet;
import org.springframework.data.repository.CrudRepository;

public interface LesnichestvoRepository extends CrudRepository<Lesnichestvo, Long> {
}
