package com.bng.ddaja.common.domain; 

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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode(callSuper = false, of = "id")
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

    @OneToMany(mappedBy = "license", fetch = FetchType.LAZY)
    private List<Word> words; 

    @OneToMany(mappedBy = "license")
    private List<Round> rounds;
    
    public void setWord(Word word) {
        this.words.add(word);
        if (word.getLicense() != this) {
            word.setLicense(this);
        }
    }

    public void setRound(Round round) {
        this.rounds.add(round);
        if (round.getLicense() != this) {
            round.setLicense(this);
        }
    }
}