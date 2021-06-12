package com.ddaja.ddaja.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Table(name = "USER")
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uSeq;
    
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(name="TOKEN_JWT")
    private String tokenJWT;

    @Column(name="TOKEN_SOCIAL")
    private String tokenSocial;

    @Column(name="TOKEN_REFERSH")
    private String tokenRefresh;

    @Column(name="SESSION_ID")
    private String sessionId;

    @Column(name="C_TYPE")
    private String cType;

    @Column(name="SOCIAL_TYPE")
    private String socialType;

    @Builder
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
