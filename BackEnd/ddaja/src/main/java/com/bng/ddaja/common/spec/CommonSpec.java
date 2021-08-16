package com.bng.ddaja.common.spec;

import com.bng.ddaja.common.domain.CommonEntity;

import org.springframework.data.jpa.domain.Specification;

public interface CommonSpec {
    
    public Specification<? extends CommonEntity> toSpecification();
    
}
