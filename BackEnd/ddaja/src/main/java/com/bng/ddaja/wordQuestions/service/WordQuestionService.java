package com.bng.ddaja.wordQuestions.service;

import java.util.ArrayList;
import java.util.List;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.domain.WordQuestion;
import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.repository.WordQuestionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class WordQuestionService {
    private WordQuestionRepository repository;

    /** WORD QUESTION ALL LIST **/
    public List<WordQuestionDTO> findAll(){

        List<WordQuestionDTO> list = new ArrayList<>();

        repository.findAll().forEach(x -> { 
            list.add( new WordQuestionDTO(x) );
        }); 

        return list;
    }

    /** WORD QUESTION ID FIND **/
    public WordQuestionDTO findById( long id ){
        return  new WordQuestionDTO ( repository.findById(id) );
    }

    /** WORD QUESTION WID LIST FIND **/
    public List<WordQuestionDTO> findByWId( long wid ){
        List<WordQuestionDTO> list = new ArrayList<>();

        repository.findByWord( Word.builder().id(wid).build() ).forEach(x -> { 
            list.add( new WordQuestionDTO(x) );
        }); 


        return list;
    }
}
