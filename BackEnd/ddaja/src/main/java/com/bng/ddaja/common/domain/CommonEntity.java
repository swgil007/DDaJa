package com.bng.ddaja.common.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
@MappedSuperclass
public class CommonEntity {
    
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
}
