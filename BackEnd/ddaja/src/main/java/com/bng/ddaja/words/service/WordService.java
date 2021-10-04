package com.bng.ddaja.words.service;

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

        System.out.println(" ==> 1");
        LicenseDTO O = LicensesService.getLicenseById(wordDTO.getLID());
        System.out.println(" ==> 2");

        License X = O.toEntity();
        System.out.println(" ==> 3");
        
        word.setLicense(X);
        System.out.println(" ==> 4");
        System.out.println(word.getLicense().getId());
        System.out.println(word.getTitle());
        System.out.println("-----");
        
        wordRepository.save(word);
        System.out.println(" ==> 5");
        return new WordDTO(word);
    }

    @Transactional
    public void createWord ( Word word ){ 
        wordRepository.save(word);
    }
}
