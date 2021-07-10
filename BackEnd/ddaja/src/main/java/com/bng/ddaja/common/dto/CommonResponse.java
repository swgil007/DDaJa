package com.bng.ddaja.common.dto;

import java.util.LinkedList;
import java.util.List;

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
public class CommonResponse<T> {
    private int totalCount;
    private List<CommonResource<T>> items;

    public CommonResponse(int totalCount, CommonResource<T> item) {
        this.totalCount = totalCount;
        List<CommonResource<T>> resourceList = new LinkedList<>();
        resourceList.add(item);
        this.items = resourceList;
    }
}
