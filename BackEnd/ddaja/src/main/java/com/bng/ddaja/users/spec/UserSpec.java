package com.bng.ddaja.users.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bng.ddaja.common.domain.User;

import org.springframework.data.jpa.domain.Specification;

public class UserSpec {
    
    public static Specification<User> nickNameLike(final String nickName) {
        return new Specification<User>() {
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (nickName == null || "".equals(nickName)) return builder.conjunction();
                return builder.like(root.get("nickName"), new StringBuilder().append("%").append(nickName).append("%").toString());
            }
        };
    }

    public static Specification<User> idEqual (final long id) {
        return new Specification<User>() {
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (id == 0) return builder.conjunction();
                return builder.equal(root.get("id"), id);
            }
        };
    }

    public static Specification<User> eMailLike(final String eMail) {
        return new Specification<User>() {
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if(eMail == null || "".equals(eMail)) return builder.conjunction();
                return builder.like(root.get("eMail"), new StringBuilder().append("%").append(eMail).append("%").toString());
            }
        };
    }
}
