package com.bng.ddaja.words.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.dto.WordSearch;
import com.bng.ddaja.words.repository.WordRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class WordService {

    private WordRepository wordRepository;

    public Page<WordDTO> getAllWordByWordSearch( WordSearch wordSearch ) {
        return wordRepository.findAll(wordSearch.toSpecification(), wordSearch.toPageable()).map( vo -> new WordDTO(vo));
    }

    public List<WordDTO> getAllWordByWordSearchTotalCount( WordSearch wordSearch ) {
        return wordRepository.findAll(wordSearch.toSpecification()).stream().map(vo -> new WordDTO(vo)).collect(Collectors.toList());
    } 

    public Word getWordByWord( long wID ) {
        return wordRepository.findById(wID);
    } 

    @Transactional
    public void createWord ( Word vo ){ 
        wordRepository.save(vo);
    }
}
