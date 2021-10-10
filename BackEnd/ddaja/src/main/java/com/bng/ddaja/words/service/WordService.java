package com.bng.ddaja.words.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.licenses.dto.LicenseDTO;
import com.bng.ddaja.licenses.repository.LicensesRepository;
import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.dto.WordSearch;
import com.bng.ddaja.words.repository.WordRepository;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WordService {

    private WordRepository wordRepository;
    private LicensesService LicensesService;

    public Page<WordDTO> getAllWordByWordSearch( WordSearch wordSearch ) {
        return wordRepository.findAll(wordSearch.toSpecification(), wordSearch.toPageable()).map( vo -> new WordDTO(vo));
    }

    public List<WordDTO> getAllWordByWordSearchTotalCount( WordSearch wordSearch ) {
        return wordRepository.findAll(wordSearch.toSpecification()).stream().map(vo -> new WordDTO(vo)).collect(Collectors.toList());
    } 

    public WordDTO findById( long wID ) {
        return new WordDTO(wordRepository.findById(wID));
    } 

    public WordDTO saveWord ( WordDTO wordDTO ){
        Word word = wordDTO.toEntity();

        LicensesService.getLicenseById(wordDTO.getLID()).valueCheck();
        word.setLicense(LicensesService.getLicenseById(wordDTO.getLID()).toEntity());
        wordRepository.save(word);
        
        return new WordDTO(word);
    }

    public WordDTO deleteWord(long wID) {

        Word word = wordRepository.findById(wID);
        WordDTO wordDTO = new WordDTO(word);
        wordRepository.delete(word);

        return wordDTO;
    }

    @Transactional
    public void createWord (Word word){ 
        wordRepository.save(word);
    }
}
