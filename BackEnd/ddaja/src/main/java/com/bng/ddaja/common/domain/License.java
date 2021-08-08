package com.bng.ddaja.common.domain; 

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_LICENSE")
@Entity
public class License extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "L_ID")
    private long id;
    
    @Column(name = "NAME")
    private String name;

    @Column(name = "IN_USE")
    private boolean inUse;

    @Column(name = "AGENCY")
    private String agency;

    @Column(name = "PASS_SCORE")
    private int passScore;

    /** 잠시 주석 처리 해놓겠습니다 ! **/
    // @Column(name = "L_CODE")
    // private LicenseCode lCode;
    // @Enumerated(EnumType.STRING)
    // private LicenseType type;

    @OneToMany(mappedBy = "license")
    private List<Word> words; 
}