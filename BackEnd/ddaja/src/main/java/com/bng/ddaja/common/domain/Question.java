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
@Table(name = "TB_QUESTION")
@NoArgsConstructor
@Entity
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Q_ID")
    private long id;
    
    @Column(name="TITLE")
    private String title;

    @Column(name="CONTENT")
    private String content;

    @Column(name="SCORE")
    private long score;

    @Column(name="NO")
    private long no;

    @Column(name="ANSWER_ONE")
    private String ANSWER_ONE;

    @Column(name="ANSWER_TWO")
    private String ANSWER_TWO;

    @Column(name="ANSWER_THR")
    private String ANSWER_THR;

    @Column(name="ANSWER_FOUR")
    private String ANSWER_FOUR;

    @Column(name="ANSWER_FIVE")
    private String ANSWER_FIVE;

    @Column(name="L_ID")
    private long lId;

    @Column(name="S_ID")
    private long sId;

    @Column(name="R_ID")
    private long rId;
}
