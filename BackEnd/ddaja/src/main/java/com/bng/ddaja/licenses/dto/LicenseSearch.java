package com.bng.ddaja.licenses.dto;

import lombok.Getter;
import lombok.Setter;

import static com.bng.ddaja.licenses.spec.LicenseSpec.subjectNameLike;
import static org.springframework.data.jpa.domain.Specification.where;

import com.bng.ddaja.common.domain.License;

import org.springframework.data.jpa.domain.Specification;
@Getter
@Setter
public class LicenseSearch {
    private String subjectName;

    public Specification<License> toSpecification() {
        return where(subjectNameLike(subjectName));
    }
}
