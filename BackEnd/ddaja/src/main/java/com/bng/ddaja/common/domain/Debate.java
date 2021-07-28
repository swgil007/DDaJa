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
@Table(name = "TB_DEBATE")
@NoArgsConstructor
@Entity
public class Debate extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="D_ID")
    private long id;

    @Column(name="Q_ID")
    private long qId;

    @Column(name="U_ID")
    private long uId;
}
