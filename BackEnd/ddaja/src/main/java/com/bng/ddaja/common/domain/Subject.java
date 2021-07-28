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
@Table(name = "TB_SUBJECT")
@NoArgsConstructor
@Entity
public class Subject extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="S_ID")
    private long id;
    
    @Column(name="NAME")
    private String name;

    @Column(name="MIN_SCORE")
    private int minScore;

    @Column(name="IN_USE")
    private int inUse;
    
    @Column(name="L_ID")
    private long lId;
}
