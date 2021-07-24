package com.bng.ddaja.wordQuestions.service;

import java.util.List;

import com.bng.ddaja.common.domain.WordQuestion;
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

    public List<WordQuestion> findAll(){
        return repository.findAll();
    }
}
