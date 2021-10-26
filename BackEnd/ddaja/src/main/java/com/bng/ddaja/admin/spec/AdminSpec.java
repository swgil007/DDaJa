package com.bng.ddaja.admin.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bng.ddaja.common.domain.Admin;

import org.springframework.data.jpa.domain.Specification;

public class AdminSpec {
    
    public static Specification<Admin> passWordEqual(final String passWord) {
        return new Specification<Admin>() {
            public Predicate toPredicate(Root<Admin> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (passWord == null || "".equals(passWord)) return builder.conjunction();
                return builder.equal(root.get("passWord"), passWord);
            }
        };
    }
}
