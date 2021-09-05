package com.bng.ddaja.words.service;

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

    /** WORD LIST - LICENSES **/
    public Page<WordDTO> getAllWordByWordSearch( WordSearch wordSearch ) {
        Page<WordDTO> xx = wordRepository.findAll(wordSearch.toSpecification(), wordSearch.toPageable()).map( vo -> new WordDTO(vo));
        

        System.out.println("BINSOO WORD TEST");
        xx.get().forEach(x -> System.out.println(x));
       
        return xx; 
    } 
    

    /** WORD INSERT **/
    @Transactional
    public void createWord ( Word vo ){ 
        wordRepository.save(vo);
    }
}
