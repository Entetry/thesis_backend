package org.example.core.search;

import org.example.core.entity.TrialPlot;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TrialPlotSpecification implements Specification<TrialPlot> {

    private SearchCriteria criteria;

    public TrialPlotSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<TrialPlot> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if("Oblast".equalsIgnoreCase(criteria.getKey())) {
            return builder.equal(root.join("oblast").get("id"), criteria.getValue());
        }
        if ("leshoz".equalsIgnoreCase(criteria.getKey())) {
            return builder.equal(root.join("leshoz").get("id"), criteria.getValue());
        }
        if ("lesnichestvo".equalsIgnoreCase(criteria.getKey())) {
            return builder.equal(root.join("lesnichestvo").get("id"), criteria.getValue());
        }
        if ("rayon".equalsIgnoreCase(criteria.getKey())) {
            return builder.equal(root.join("rayon").get("id"), criteria.getValue());
        }
        if ("plho".equalsIgnoreCase(criteria.getKey())) {
            return builder.equal(root.join("plho").get("id"), criteria.getValue());
        }
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }

        return null;
    }
}