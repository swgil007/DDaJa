package com.bng.ddaja.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;

import com.bng.ddaja.common.enums.AdminRule; 

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "TB_ADMIN")
@NoArgsConstructor
@Entity
public class Admin extends CommonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="A_ID")
    private long Id;

    /** USER ID & ADMIN ID ??? **/
    @Column(name="ID")
    private String userId;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="IN_USE")
    private String inUse;

    @Enumerated(EnumType.STRING)
    private AdminRule role;
}
