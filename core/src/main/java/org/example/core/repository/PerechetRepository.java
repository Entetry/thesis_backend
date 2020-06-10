package org.example.core.repository;

import org.example.core.entity.Perechet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerechetRepository extends CrudRepository<Perechet, Long> {
}
