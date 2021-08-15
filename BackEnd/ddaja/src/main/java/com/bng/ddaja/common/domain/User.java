package com.bng.ddaja.common.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bng.ddaja.common.enums.TokenType;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false, of = "id")
@Table(name = "TB_USER")
@NoArgsConstructor
@Entity
public class User extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "U_ID")
    private long id;
    
    @Column(name = "ID")
    private String userId;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Column(name = "EMAIL")
    private String eMail;

    @Column(name = "TOKEN_OAUTH")
    private String tokenOAuth;

    @Enumerated(EnumType.STRING)
    @Column(name = "TOKEN_TYPE")
    private TokenType tokenType;

    @Column(name = "PROFILE_IMG")
    private String profileImg;

    @OneToMany(mappedBy = "user")
    private List<UserQuestion> userQuestions;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @OneToMany(mappedBy = "user")
    private List<StateQuestion> stateQuestion;

    @Builder
    public User(long id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }

    public void setUserQuestion(UserQuestion userQuestion) {
        this.userQuestions.add(userQuestion);
        if(userQuestion.getUser() != this) {
            userQuestion.setUser(this);
        }
    }

    public void setToken(Token token) {
        this.tokens.add(token);
        if(token.getUser() != this) {
            token.setUser(this);
        }
    }

    public void setStateQuestion(StateQuestion stateQuestion){
        this.stateQuestion.add(stateQuestion);

        if(stateQuestion.getUser() != this) {
            stateQuestion.setUser(this);
        }
    }
}
