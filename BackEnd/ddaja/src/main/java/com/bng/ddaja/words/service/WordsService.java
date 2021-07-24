package com.bng.ddaja.words.service;

import java.util.List;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.repository.WordsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WordsService {

    private static final Logger log = LoggerFactory.getLogger(WordsService.class);

    private WordsRepository repository;

    /**
     * - 단어 외우기
     * @param L_ID
     * @return List<WordDTO>
     * 
     **/
    public List<Word> findAll( ) { 

        return repository.findAll();
    } 
}
