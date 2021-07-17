package com.ddaja.repository;

import java.util.List;

import javax.inject.Inject;

import com.bng.ddaja.DdajaApplication;
import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.example.repository.user.UserRepository;
import com.bng.ddaja.words.repository.WordsRepository;

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
public class BinTest {
    
    @MockBean
    private WordsRepository wordsRepository; 

    @Test
    public void wordTest(){
        
        // given
        long wId = 9;
        String title = "운영체제 필수 암기";

        // when
        Word wordVO = wordsRepository.findById(wId);
        List<Word> wordVOList = wordsRepository.findAll();


        // then
        assertThat(wordVOList.get(0).getTitle()).isEqualTo(title);
    }

}
