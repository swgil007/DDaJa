package com.bng.ddaja.common.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
@Table(name = "TB_ROUND")
@NoArgsConstructor
@Entity
public class Round {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="R_ID")
    private long id;

    @Column(name="EXAM_DATE")
    private Date examDate;

    @Column(name="EXAM_YEAR")
    private String examYear;

    @Column(name="ROUND")
    private int round;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "L_ID")
    private License license;

    public void setLicense(License license) {
        if(this.license != null) {
            this.license.getRounds().remove(this);
        }
        this.license = license;
        if(!license.getRounds().contains(this)) {
            license.setRound(this);
        }
    }
}
