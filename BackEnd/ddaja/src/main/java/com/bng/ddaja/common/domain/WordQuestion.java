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
import lombok.Setter;
import lombok.ToString;
 

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_WORD_QUESTION")
@Entity
public class WordQuestion extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WQ_ID")
    private long Id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "L_ID")
    private long LId;

    @Column(name = "W_ID")
    private long WId;

    // @ManyToOne
    // @JoinColumn //(name = "W_ID")
    // private Word word;

} 