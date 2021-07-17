package com.bng.ddaja.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bng.ddaja.common.enums.LicenseCode;
import com.bng.ddaja.common.enums.LicenseType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "TB_LICENSE")
@NoArgsConstructor
@Entity
public class License extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "L_ID")
    private long id;

    @Column(name = "L_CODE")
    private LicenseCode lCode;
    
    @Column(name = "NAME")
    private String name;

    @Column(name = "IN_USE")
    private boolean inUse;

    @Column(name = "AGENCY")
    private String agency;

    @Enumerated(EnumType.STRING)
    private LicenseType type;

    @Column(name = "PASS_SCORE")
    private int passScore;

    @OneToMany(mappedBy = "license")
    private List<Word> words = new ArrayList<Word>();

    // 연관관계 편의 메소드
    public void addWord(Word word) {
        this.words.add(word);
        if (word.getLicense() != this) {
            word.setLicense(this);
        }
    }
}