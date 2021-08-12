package com.bng.ddaja.common.dto;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.springframework.data.domain.Page;

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
public class CommonResponse {
    private int totalCount;
    private List<CommonResource> items;

    public CommonResponse (List<CommonResource> items) {
        this.totalCount = items.size();
        this.items = items;
    }
    public CommonResponse(int totalCount, CommonResource item) {
        this.totalCount = totalCount;
        List<CommonResource> resourceList = new LinkedList<>();
        resourceList.add(item);
        this.items = resourceList;
    }
}
