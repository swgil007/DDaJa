package com.bng.ddaja.common.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
@MappedSuperclass
public class CommonEntity {
    
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "CREATED_DATE", updatable=false, insertable=false)
    public Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "MODIFIED_DATE")
    public Date modifiedDate;
}
