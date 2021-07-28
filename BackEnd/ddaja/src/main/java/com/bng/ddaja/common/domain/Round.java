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
@Table(name = "TB_ROUND")
@NoArgsConstructor
@Entity
public class Round {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="R_ID")
    private long id;

    @Column(name="EXAM_DATE")
    private String examDate;

    @Column(name="EXAM_YEAR")
    private String examYear;

    @Column(name="ROUND")
    private int round;

    @Column(name="L_ID")
    private String lId;
}
