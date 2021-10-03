package com.bng.ddaja.wordQuestions.service;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.domain.WordQuestion;
import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.dto.WordQuestionSearch;
import com.bng.ddaja.wordQuestions.repository.WordQuestionRepository;
import com.bng.ddaja.words.repository.WordRepository;
import com.bng.ddaja.words.service.WordService;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class WordQuestionService {

    private WordQuestionRepository wordQuestionRepository;
    private WordRepository wordRepository;

    public Page<WordQuestionDTO> getAllWordQuestionByWordQuestionSearch( WordQuestionSearch wordQuestionSearch){
        return wordQuestionRepository.findAll(wordQuestionSearch.toSpecification(), wordQuestionSearch.toPageable()).map( vo -> new WordQuestionDTO(vo));
    }

    public WordQuestionDTO saveWordQuestion( WordQuestionDTO wordQuestionDTO, long wID){
        WordQuestion wordQuestion = wordQuestionDTO.toEntity();
        wordQuestion.setWord(wordRepository.findById(wID));
        wordQuestionRepository.save(wordQuestion);
        return new WordQuestionDTO(wordQuestion);
    }
    
    public WordQuestionDTO deleteWordQuestion( long id ){
        WordQuestion wordQuestion = wordQuestionRepository.getOne(id);
        wordQuestionRepository.delete(wordQuestion);
        return new WordQuestionDTO(wordQuestion);
    }
}
