package com.bng.ddaja.common.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.bng.ddaja.common.hateos.CommonHateos;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonResource {
    private CommonDTO item;
    private List<Link> hateos;

    public CommonResource(CommonDTO item) {
        this.item = item;
    }
    public CommonResource(CommonDTO item, CommonHateos[] hateos) {
        this.item = item;
        this.hateos = Arrays.stream(hateos).map(h -> h.initLink(item.getId())).collect(Collectors.toList());
    }
}
