package com.bng.ddaja.common.domain.dto;

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
