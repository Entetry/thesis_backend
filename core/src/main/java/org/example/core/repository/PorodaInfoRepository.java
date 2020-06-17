package org.example.core.repository;

import org.example.core.entity.PorodaInfo;
import org.example.core.entity.Rayon;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorodaInfoRepository extends CrudRepository<PorodaInfo, Long>, JpaSpecificationExecutor<PorodaInfo> {
}
