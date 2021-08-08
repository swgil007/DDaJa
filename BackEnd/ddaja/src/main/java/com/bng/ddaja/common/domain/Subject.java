package com.bng.ddaja.common.domain;

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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
@Table(name = "TB_SUBJECT")
@NoArgsConstructor
@Entity
public class Subject extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="S_ID")
    private long id;
    
    @Column(name="NAME")
    private String name;

    @Column(name="MIN_SCORE")
    private int minScore;

    @Column(name="IN_USE")
    private int inUse;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "L_ID")
    private License license;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<UserQuestion> userQuestions;

    public void setLicense(License license) {
        if(this.license != null) {
            this.license.getSubjects().remove(this);
        }
        this.license = license;
        if(!license.getSubjects().contains(this)) {
            license.setSubject(this);
        }
    }

    public void setUserQuestion(UserQuestion userQuestion) {
        this.userQuestions.add(userQuestion);
        if(userQuestion.getSubject() != this) {
            userQuestion.setSubject(this);
        }
    }
}
