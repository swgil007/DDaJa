package com.bng.ddaja.users.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.sasl.AuthenticationException;

import com.bng.ddaja.common.api.social.GoogleResponse;
import com.bng.ddaja.common.api.social.SocialResponse;
import com.bng.ddaja.common.config.exception.exception.MemberNotFoundException;
import com.bng.ddaja.common.config.exception.exception.NotAcceptableSocialLoginException;
import com.bng.ddaja.common.config.exception.exception.NotAcceptableSocialResponseException;
import com.bng.ddaja.common.domain.Token;
import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.common.dto.CommonUserDetails;
import com.bng.ddaja.common.dto.SocialAccessToken;
import com.bng.ddaja.common.enums.HttpMethods;
import com.bng.ddaja.common.util.Constants;
import com.bng.ddaja.common.util.OKHttp;
import com.bng.ddaja.tokens.repository.TokenRepository;
import com.bng.ddaja.tokens.service.TokenService;
import com.bng.ddaja.users.dto.UserDTO;
import com.bng.ddaja.users.dto.UserSearch;
import com.bng.ddaja.users.repository.UserRepository;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.Response;

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    private TokenService tokenService;
    private final String MESSAGE_MEMBER_NOT_FOUND = "Token Info Valid But Member Not Founded";
    private final String MESSAGE_MEMBER_NOT_FOUND_KR = "???????????? ???????????? ????????????.";

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(v -> new UserDTO(v)).collect(Collectors.toList());
    }

    public Page<UserDTO> getUsersByUserSearch(UserSearch userSearch) {
        return userRepository.findAll(userSearch.toSpecification(), userSearch.toPageable()).map(vo -> new UserDTO(vo));
    }

    public UserDTO getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent())
            throw new MemberNotFoundException(MESSAGE_MEMBER_NOT_FOUND_KR);
        return new UserDTO(optionalUser.get());
    }

    public UserDTO getUserBySocialToken(SocialAccessToken socialAccessToken) throws IOException, MemberNotFoundException, NotAcceptableSocialLoginException {
        SocialResponse socialResponse;
        if(socialAccessToken.getTokenType() == null) throw new NotAcceptableSocialLoginException("Social Login Type is Not Included");
        switch(socialAccessToken.getTokenType()) {
            case KAKAO:
                socialResponse = requestKakaoUserInfo(socialAccessToken);
                break;
            case GOOGLE:
                socialResponse = requestGoogleUserInfo(socialAccessToken);
                break;
            default:
                throw new NotAcceptableSocialLoginException();
        }
        Token token = tokenRepository.findByClientID(socialResponse.getId());
        if(token == null) return createUserBySocialResponse(socialResponse);
        if(token.getUser() == null) throw new MemberNotFoundException(MESSAGE_MEMBER_NOT_FOUND);
        UserDTO userDTO = new UserDTO(token.getUser());
        userDTO.setTokenPair(tokenService.getTokenPair(userDTO));
        return userDTO;
    }

    public UserDTO patchUserByUserDTO(UserDTO userDTO) {
        Optional<User> originUser = userRepository.findById(userDTO.getId());
        if(!originUser.isPresent()) throw new MemberNotFoundException(MESSAGE_MEMBER_NOT_FOUND_KR);
        return new UserDTO(userRepository.save(userDTO.toEntity()));
    }

    private UserDTO createUserBySocialResponse(SocialResponse socialResponse) throws AuthenticationException {
        User user = userRepository.save(User.builder().build());
        tokenRepository.save(Token.builder().clientID(socialResponse.getId()).user(user).build());
        UserDTO userDTO = new UserDTO(user, true);
        userDTO.setTokenPair(tokenService.getTokenPair(userDTO));
        return userDTO;
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

    private SocialResponse requestGoogleUserInfo(SocialAccessToken socialAccessToken) throws IOException {
        final String GOOGLE_USERINFO_URI = "https://www.googleapis.com/oauth2/v3/userinfo";
        final String GOOGLE_USERINFO_QUERY = "?access_token=";
        String requestURI = new StringBuilder()
                                                .append(GOOGLE_USERINFO_URI)
                                                .append(GOOGLE_USERINFO_QUERY)
                                                .append(socialAccessToken.getAccessToken())
                                                .toString();
        Response response = OKHttp.okHttpRequest(requestURI, null, null, HttpMethods.GET);
        if(!response.isSuccessful()) {
            throw new NotAcceptableSocialResponseException();
        }
        GoogleResponse result = new Moshi.Builder()
                                            .add(Date.class, new Rfc3339DateJsonAdapter())
                                            .build()
                                            .adapter(GoogleResponse.class)
                                            .fromJson(response.body()
                                            .source());
        response.body().close();
        log.info(result.toString());
        result.setId(result.getSub());
        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException { 
        return new CommonUserDetails();
    }
    
}
