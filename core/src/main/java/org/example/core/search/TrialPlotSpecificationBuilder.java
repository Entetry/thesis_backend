package org.example.core.search;

import org.example.core.entity.TrialPlot;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrialPlotSpecificationBuilder {

    private final List<SearchCriteria> params;

    public TrialPlotSpecificationBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public TrialPlotSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<TrialPlot> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
                .map(TrialPlotSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);

        return result;
    }
}
