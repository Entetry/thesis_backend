package org.example.core.repository;

import org.example.core.entity.TrialPlot;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrialPlotRepository extends CrudRepository<TrialPlot, Long>, JpaSpecificationExecutor<TrialPlot> {
}
