package com.ddaja.repository;

import java.util.List;

import javax.inject.Inject;

import com.ddaja.ddaja.DdajaApplication;
import com.ddaja.ddaja.domain.user.User;
import com.ddaja.ddaja.repository.user.UserRepository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DdajaApplication.class)
public class UserRepositoryTest {
    
    @MockBean
    private UserRepository userRepository;

    //@After
    public void clean() {
        userRepository.deleteAll();
    }

    @Test
    public void saveAndGetUser() {
        // given
        String id = "ddajauser";
        String name = "김로그";

        //userRepository.save(User.builder().id(id).name(name).build());
        
        // when
        //List<User> userList = userRepository.findAll();
        User user = userRepository.findById(id);

        // then
        //User user = userList.get(0);
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getName()).isEqualTo(name);
    }

    @Test
    public void findAllUsers() {
        
        // when
        int userCount = 1;
        List<User> userList = userRepository.findAll();

        // console
        userList.stream().forEach(user -> System.out.println(user));
        
        // then
        assertThat(userList.size()).isEqualTo(userCount);
    }
}
