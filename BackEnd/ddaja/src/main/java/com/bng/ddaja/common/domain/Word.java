package com.bng.ddaja.common.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
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
    private long Id;

    @Column(name="TITLE")
    private String title;

    @Column(name="L_ID")
    private long lid;


    // @OneToMany(mappedBy = "word")
    // private List<WordQuestion> wordQuestions = new ArrayList<WordQuestion>();

}
