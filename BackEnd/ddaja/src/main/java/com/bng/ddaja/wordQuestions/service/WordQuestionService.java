package com.bng.ddaja.wordQuestions.service;

import java.util.ArrayList;
import java.util.List;

import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.repository.WordQuestionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WordQuestionService {
    
    private static final Logger log = LoggerFactory.getLogger(WordQuestionService.class);

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

        repository.findByWId( wid ).forEach(x -> { 
            list.add( new WordQuestionDTO(x) );
        }); 


        return list;
    }
}
