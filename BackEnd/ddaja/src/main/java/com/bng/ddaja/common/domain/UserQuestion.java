package com.bng.ddaja.common.domain;

import java.util.ArrayList;
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
import com.bng.ddaja.common.enums.UserQuestionResultType;
import com.bng.ddaja.common.enums.UserQuestionType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "TB_USER_QUESTION")
@NoArgsConstructor
@Entity
public class UserQuestion extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UQ_ID")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name="TYPE")
    private UserQuestionType type;

    /** 이거 공통적으로 많이 쓰여서 이름통일 시키고 돌려 쓰자 ! **/
    @Column(name="RESULT")
    private UserQuestionResultType result;

    /** 일단 ENUM 같이 사용 하지만 변경 꼭 **/
    @Column(name="RESULT_FINAL")
    private UserQuestionResultType resultFinal;

    @Column(name="RESULT_SCORE")
    private int resultScore;

    @Column(name="SOLVED_DATE")
    private String solvedDate;

    @Column(name="L_ID")
    private long lId;

    @Column(name="S_ID")
    private long sId;

    @Column(name="R_ID")
    private long rId;

    @Column(name="U_ID")
    private long uId;


    
}
