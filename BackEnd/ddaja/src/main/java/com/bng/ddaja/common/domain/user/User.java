package com.bng.ddaja.common.domain.user;

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
    @Column(name="U_ID")
    private long uId;
    
    private String id;

    @Column(name="NICK_NAME")
    private String nickName;

    @Builder
    public User(String id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }
}
