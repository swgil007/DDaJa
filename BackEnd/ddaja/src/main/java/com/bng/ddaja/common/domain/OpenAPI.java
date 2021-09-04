package com.bng.ddaja.common.domain;

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
@Table(name = "TB_OPEN_API")
@NoArgsConstructor
@Entity
public class OpenAPI extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OA_ID")
    private long id;

    @Column(name = "CNT_RECPT")
    private long cntRecpt;

    @Column(name = "CNT_PASS")
    private long cntPass;

    @Column(name = "R_ID")
    private long rID;

    @Column(name = "L_ID")
    private long lId;
}
