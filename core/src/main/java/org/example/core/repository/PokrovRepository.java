package org.example.core.repository;

import org.example.core.entity.Pokrov;
import org.example.core.entity.Tym;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokrovRepository extends CrudRepository<Pokrov, Long> {
}
