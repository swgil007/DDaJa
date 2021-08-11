package com.bng.ddaja.licenses.dto;

import lombok.Getter;
import lombok.Setter;

import static com.bng.ddaja.licenses.spec.LicenseSpec.subjectNameLike;
import static org.springframework.data.jpa.domain.Specification.where;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.spec.SpecBuilder;

import org.springframework.data.jpa.domain.Specification;

@Getter
@Setter
public class LicenseSearch {
    private String subjectName;

    public Specification<License> toSpecification() {
        Specification<License> specification = where(null);
        specification.and(where(subjectNameLike(subjectName)));
        // if(subjectName != null) {
        //     specification.and(where(subjectNameLike(subjectName)));
        // }
        //Specification<License> specification = where(subjectNameLike(subjectName));
        return SpecBuilder.builder(License.class).addSpec(where(subjectNameLike(subjectName))).toSpecification();
    }
}
