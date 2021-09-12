package com.bng.ddaja.wordQuestions.service;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.domain.WordQuestion;
import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.dto.WordQuestionSearch;
import com.bng.ddaja.wordQuestions.repository.WordQuestionRepository;
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
    private WordService wordService;

    public Page<WordQuestionDTO> getAllWordQuestionByWordQuestionSearch( WordQuestionSearch wordQuestionSearch){
        return wordQuestionRepository.findAll(wordQuestionSearch.toSpecification(), wordQuestionSearch.toPageable()).map( vo -> new WordQuestionDTO(vo));
    }

    public WordQuestionDTO saveWordQuestion( WordQuestionDTO wordQuestionDTO){
        WordQuestion wordQuestionVO = wordQuestionDTO.toEntity();
        wordQuestionRepository.save(wordQuestionVO);
        return new WordQuestionDTO(wordQuestionVO);
    }

    public WordQuestionDTO updateWordQuestion( WordQuestionDTO wordQuestionDTO, long id){
        WordQuestion wordQuestionVO = wordQuestionDTO.toEntity();
        wordQuestionVO.setWord(wordService.findById(id));
        wordQuestionRepository.save(wordQuestionVO);
        return new WordQuestionDTO(wordQuestionVO);
    }    
    
    /*
    ** Delete 처리를 했는데 Vo 를 반환하지 않고 상태 코드를 반환해주는건 어떨까 ?
    */
    public WordQuestionDTO deleteWordQuestion( long id ){
        WordQuestion wordQuestionVO = wordQuestionRepository.getOne(id);
        wordQuestionRepository.delete(wordQuestionVO);
        return new WordQuestionDTO(wordQuestionVO);
    }
}
