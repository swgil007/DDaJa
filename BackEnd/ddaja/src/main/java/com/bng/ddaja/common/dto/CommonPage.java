package com.bng.ddaja.common.dto;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonPage {
    private int page;
    private int size;
    private boolean isLast;
    private boolean isFirst;
    private boolean isEmpty;
    private int totalPage;
    private int totalItems;

    CommonPage(Page<? extends CommonDTO> pageEntity) {
        page = pageEntity.getNumber() + 1;
        size = pageEntity.getSize();
        isLast = pageEntity.isLast();
        isFirst = pageEntity.isFirst();
        isEmpty = pageEntity.isEmpty();
        totalPage = pageEntity.getTotalPages();
        totalItems = Long.valueOf(pageEntity.getTotalElements()).intValue();
    }
}