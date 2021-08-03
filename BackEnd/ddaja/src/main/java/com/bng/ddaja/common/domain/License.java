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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bng.ddaja.common.enums.LicenseCode;
import com.bng.ddaja.common.enums.LicenseType;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "L_CODE")
    private LicenseCode lCode;
    
    @Column(name = "NAME")
    private String name;

    @Column(name = "IN_USE")
    private boolean inUse;

    @Column(name = "AGENCY")
    private String agency;

    @Column(name = "PASS_SCORE")
    private int passScore;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private LicenseType type;

    @OneToMany(mappedBy = "license")
    private List<Word> words; 

    //연관관계 편의 메소드
    public void setWord(Word word) {
        this.words.add(word);
        if (word.getLicense() != this) {
            word.setLicense(this);
        }
    }
}