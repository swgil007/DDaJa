package com.bng.ddaja.users.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.common.api.social.KaKaoResponse;
import com.bng.ddaja.common.api.social.SocialResponse;
import com.bng.ddaja.common.config.error.exception.MemberNotFoundException;
import com.bng.ddaja.common.config.error.exception.NotAcceptableSocialLoginException;
import com.bng.ddaja.common.config.error.exception.NotAcceptableSocialResponseException;
import com.bng.ddaja.common.domain.Token;
import com.bng.ddaja.common.dto.SocialAccessToken;
import com.bng.ddaja.common.enums.HttpMethods;
import com.bng.ddaja.common.enums.TokenType;
import com.bng.ddaja.common.util.Constants;
import com.bng.ddaja.common.util.OKHttp;
import com.bng.ddaja.tokens.dto.TokenDTO;
import com.bng.ddaja.tokens.repository.TokensRepository;
import com.bng.ddaja.tokens.service.TokensService;
import com.bng.ddaja.users.dto.UserDTO;
import com.bng.ddaja.users.repository.UsersRepository;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.Response;

@Slf4j
@AllArgsConstructor
@Service
public class UsersService {
    private UsersRepository usersRepository;
    private TokensRepository tokensRepository;

    public List<UserDTO> getUsers() {
        return usersRepository.findAll().stream().map(v -> new UserDTO(v)).collect(Collectors.toList());
    }

    public UserDTO getUserById(long id) {
        return new UserDTO(usersRepository.findById(id));
    }

    public UserDTO getUserBySocialToken(SocialAccessToken socialAccessToken) throws IOException, MemberNotFoundException, NotAcceptableSocialLoginException {
        SocialResponse socialResponse;
        if(socialAccessToken.getTokenType() == null) throw new NotAcceptableSocialLoginException("Social Login Type is Not Included");
        switch(socialAccessToken.getTokenType()) {
            case KAKAO:
                socialResponse = requestKakaoUserInfo(socialAccessToken);
                break;
            default:
                throw new NotAcceptableSocialLoginException();
        }
        Token token = tokensRepository.findByClientID(socialResponse.getId());
        // 204 ? 202 ?
        if(token == null) throw new MemberNotFoundException();
        if(token.getUser() == null ) throw new MemberNotFoundException("Token Info Valid But Member Not Founded");
        return new UserDTO(token.getUser());
    }

    public UserDTO createUserBySocialToken(SocialAccessToken socialAccessToken) {
        return null;
    }

    private SocialResponse requestKakaoUserInfo(SocialAccessToken socialAccessToken) throws IOException {
        String authorizationValue = Constants.BEARER + " " + socialAccessToken.getAccessToken();
        Response response = OKHttp.okHttpRequest("https://kapi.kakao.com/v2/user/me", new Headers.Builder().add(Constants.AUTHORIZATION, authorizationValue).build(), null, HttpMethods.GET);
        if(!response.isSuccessful()) {
            throw new NotAcceptableSocialResponseException();
        }
        SocialResponse result = new Moshi.Builder()
                                            .add(Date.class, new Rfc3339DateJsonAdapter())
                                            .build()
                                            .adapter(SocialResponse.class)
                                            .fromJson(response.body()
                                            .source());
        response.body().close();
        return result;
    }
}
