package org.example.core.repository;

import org.example.core.entity.Pochva;
import org.example.core.entity.PodrostPodlesok;
import org.example.core.entity.Rayon;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodrostPodlesokRepository extends CrudRepository<PodrostPodlesok, Long>, JpaSpecificationExecutor<PodrostPodlesok> {

}
