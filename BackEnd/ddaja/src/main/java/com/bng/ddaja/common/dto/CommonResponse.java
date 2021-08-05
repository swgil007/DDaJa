package com.bng.ddaja.common.dto;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
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
