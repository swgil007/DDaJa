package com.bng.ddaja.licenses.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.Subject;

import org.springframework.data.jpa.domain.Specification;

public class LicenseSpec {
    public static Specification<License> subjectNameLike(final String subjectName) {
        return new Specification<License>() {
            public Predicate toPredicate(Root<License> root, CriteriaQuery<?> query,
            CriteriaBuilder builder) {
                if ("".equals(subjectName)) return null;
                Join<License, Subject> j = root.join("subjects", JoinType.INNER);
                return builder.like(j.<String>get("name"), new StringBuilder().append("%").append(subjectName).append("%").toString());
            }
        };
    }
}
