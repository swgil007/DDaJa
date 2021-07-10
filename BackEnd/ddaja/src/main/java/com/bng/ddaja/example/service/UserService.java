package com.bng.ddaja.example.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bng.ddaja.common.domain.user.User;
import com.bng.ddaja.common.dto.CommonParameter;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.hateos.licenses.Licenses;
import com.bng.ddaja.example.dto.UserDTO;
import com.bng.ddaja.example.repository.user.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{
    
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public User findUserInfoById(String id) {
        User user = userRepository.findById(id);
        UserDTO userDTO = new UserDTO();
        //userDTO.setId(user.getId());
        //userDTO.setNickName(user.getNickName());
        return user;
    }

    // public UserDTO findUser(long uId) {
    //     User userInfo = new User();
    //     userInfo.setUId(uId);
    //     User user = userRepository.findByUid(uId);
    //     UserDTO userDTO = new UserDTO();
    //     userDTO.setId(user.getId());
    //     userDTO.setNickName(user.getNickName());
    //     return userDTO;
    // }

    public CommonResponse<UserDTO> findUserListByParameter(CommonParameter parameter) {
        List<User> userList = userRepository.findAll();
        List<CommonResource<UserDTO>> resourceList = userList.stream()
        .map(user -> new UserDTO(user))
        .map(dto -> new CommonResource<UserDTO>(
            dto
            , Arrays.stream(Licenses.values())
                .map(
                    hateos -> hateos.initLink(dto.getUId())
                )
                .collect(Collectors.toList())
            )
        ).collect(Collectors.toList());
        return new CommonResponse<UserDTO>(resourceList.size(), resourceList);
    }
    @Override
    public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException {
        return userRepository.findByNickName(nickName);
    }
}
