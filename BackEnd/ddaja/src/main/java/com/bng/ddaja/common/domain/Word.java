package com.bng.ddaja.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TB_WORD")
@Entity
public class Word extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="W_ID")
    private long wId;

    @Column(name="TITLE")
    private String title;

    @ManyToOne
    @JoinColumn(name="L_ID")
    private License license;

    // 연관관계 편의 메소드
    public void setLicense(License license) {
        if(this.license != null) {
            this.license.getWords().remove(this);
        }
        this.license = license;
        if(!license.getWords().contains(this)) {
            license.getWords().add(this);
        }
    }
}
