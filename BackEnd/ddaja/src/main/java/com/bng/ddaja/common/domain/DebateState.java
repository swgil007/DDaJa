package com.bng.ddaja.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bng.ddaja.common.enums.DebateStateType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated; 

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "TB_DEBATE_STATE")
@NoArgsConstructor
@Entity
public class DebateState extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DS_ID")
    private long id;

    @Enumerated(EnumType.STRING)
    private DebateStateType state;

    @Column(name="Q_ID")
    private long qId;

    @Column(name="U_ID")
    private long uId;
}
