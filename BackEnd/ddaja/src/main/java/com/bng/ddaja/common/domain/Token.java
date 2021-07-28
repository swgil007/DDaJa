package com.bng.ddaja.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bng.ddaja.common.enums.LicenseCode;
import com.bng.ddaja.common.enums.LicenseType;

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
