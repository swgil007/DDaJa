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
@Table(name = "TB_DEBATE_COMMENT")
@NoArgsConstructor
@Entity
public class DebateComment extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DC_ID")
    private long id;

    @Column(name="CONTENT")
    private String content;

    @Column(name="Q_ID")
    private long qId;

    @Column(name="U_ID")
    private long uId;
}
