package com.bng.ddaja.common.dto;

import java.util.Date;

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
}
