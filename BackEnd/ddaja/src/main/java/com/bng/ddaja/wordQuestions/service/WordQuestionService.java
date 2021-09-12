package com.bng.ddaja.wordQuestions.service;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.domain.WordQuestion;
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

    public WordQuestionDTO saveWordQuestion( WordQuestionDTO wordQuestionDTO){
        WordQuestion wordQuestionVO = wordQuestionDTO.toEntity();
        wordQuestionRepository.save(wordQuestionVO);
        return new WordQuestionDTO(wordQuestionVO);
    }

    public WordQuestionDTO updateWordQuestion( WordQuestionDTO wordQuestionDTO, long id){
        // 진행중
        return null;
    }    
    
    public WordQuestionDTO deleteWordQuestion( long id){
        // 진행중
        return null;
    }
}
