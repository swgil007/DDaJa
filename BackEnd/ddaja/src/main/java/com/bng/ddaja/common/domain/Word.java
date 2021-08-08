package com.bng.ddaja.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode(callSuper = false, of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_WORD")
@Entity
public class Word extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="W_ID")
    private long id;

    @Column(name="TITLE")
    private String title;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "L_ID")
    private License license;


    @OneToMany(mappedBy = "word", fetch = FetchType.LAZY)
    private List<WordQuestion> wordQuestions = new ArrayList<WordQuestion>();

    public void setLicense(License license) {
        if(this.license != null) {
            this.license.getWords().remove(this);
        }
        this.license = license;
        if(!license.getWords().contains(this)) {
            license.setWord(this);
        }
    }

    public void setWordQuestion(WordQuestion wordQuestion) {
        this.wordQuestions.add(wordQuestion);
        if(wordQuestion.getWord() != this) {
            wordQuestion.setWord(this);
        }
    }
}