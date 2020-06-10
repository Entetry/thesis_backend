package org.example.core.repository;

import org.example.core.entity.ForestType;
import org.example.core.entity.Tym;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForestTypeRepository extends CrudRepository<ForestType, Long> {
}
