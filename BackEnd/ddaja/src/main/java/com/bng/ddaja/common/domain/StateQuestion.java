package com.bng.ddaja.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bng.ddaja.common.enums.StateQuestionType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "TB_STATE_QUESTION")
@NoArgsConstructor
@Entity
public class StateQuestion extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SQ_ID")
    private long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name="STATE")
    private StateQuestionType state;

    @Column(name="L_ID")
    private long lId;

    @Column(name="S_ID")
    private long sId;

    @Column(name="R_ID")
    private long rId;

    @Column(name="Q_ID")
    private long qId;

    @Column(name="U_ID")
    private long uId;

}
