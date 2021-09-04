package com.bng.ddaja.common.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonDTO {
    public long id;
    public Date createdDate;
    public Date modifiedDate;
    @JsonInclude(Include.NON_NULL)
    public Boolean isCreated = null;
}
