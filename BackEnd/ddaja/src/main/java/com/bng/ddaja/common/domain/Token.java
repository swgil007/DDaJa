package com.bng.ddaja.common.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "TB_TOKEN")
@NoArgsConstructor
@Entity
public class Token extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="T_ID")
    private long id;
    
    @Column(name="JWT")
    private String jwt;
    
    @Column(name="REFRESH")
    private String refresh;

    @Column(name="EXPIRE")
    private Date expire;

    @Column(name="ISSUANCE")
    private String issuance;

    @Column(name="U_ID")
    private long uId;
}
