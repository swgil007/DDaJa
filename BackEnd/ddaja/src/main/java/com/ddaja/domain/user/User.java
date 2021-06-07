package com.ddaja.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "USER")
@Entity
public class User {

    @Id
    @GeneratedValue
    private long uSeq;
    
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(name="TOKEN_JWT")
    private String tokenJWT;

    @Column(name="TOKEN_SOCIAL")
    private String tokenSocial;

    @Column(name="TOKEN_REFRESH")
    private String tokenRefresh;

    @Column(name="SESSION_ID")
    private String sessionId;

    @Column(name="C_TYPE")
    private String cType;

    @Column(name="SOCIAL_TYPE")
    private String socialType;
}
