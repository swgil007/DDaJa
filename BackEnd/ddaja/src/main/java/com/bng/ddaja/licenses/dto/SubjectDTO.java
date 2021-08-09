package com.bng.ddaja.licenses.dto;

import com.bng.ddaja.common.domain.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    private long id;
    private String name;
    private int minScore;
    private boolean inUse;

    SubjectDTO(Subject  vo) {
        this.id = vo.getId();
        this.name = vo.getName();
        this.minScore = vo.getMinScore();
        this.inUse = vo.isInUse();
    }
}
