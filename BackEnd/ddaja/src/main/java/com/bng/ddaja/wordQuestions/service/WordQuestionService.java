package com.bng.ddaja.wordQuestions.service;

import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.dto.WordQuestionSearch;
import com.bng.ddaja.wordQuestions.repository.WordQuestionRepository;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class WordQuestionService {
    private WordQuestionRepository wordQuestionRepository;

    public Page<WordQuestionDTO> getAllWordQuestionByWordQuestionSearch( WordQuestionSearch wordQuestionSearch){
        return wordQuestionRepository.findAll(wordQuestionSearch.toSpecification(), wordQuestionSearch.toPageable()).map( vo -> new WordQuestionDTO(vo));
    }
}
