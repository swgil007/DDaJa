package com.bng.ddaja.words.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.licenses.repository.LicensesRepository;
import com.bng.ddaja.licenses.service.LicensesService;
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
    private LicensesRepository licensesRepository;
    private LicensesService licensesService;

    public Page<WordDTO> getAllWordByWordSearch( WordSearch wordSearch ) {
        return wordRepository.findAll(wordSearch.toSpecification(), wordSearch.toPageable()).map( vo -> new WordDTO(vo));
    }

    public List<WordDTO> getAllWordByWordSearchTotalCount( WordSearch wordSearch ) {
        return wordRepository.findAll(wordSearch.toSpecification()).stream().map(vo -> new WordDTO(vo)).collect(Collectors.toList());
    } 

    public Word findById( long wID ) {
        return wordRepository.findById(wID);
    } 

    public WordDTO saveWord ( WordDTO wordDTO, long lID ){
        Word word = wordDTO.toEntity();
        word.setLicense(licensesService.getLicenseById(lID).toEntity());
        // word.setLicense(licensesRepository.findById(lID));
        wordRepository.save(word);
        return new WordDTO(word);
    }

    @Transactional
    public void createWord ( Word word ){ 
        wordRepository.save(word);
    }
}
