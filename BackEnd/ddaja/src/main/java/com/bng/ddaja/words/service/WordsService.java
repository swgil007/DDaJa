package com.bng.ddaja.words.service;

import java.util.ArrayList;
import java.util.List;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.repository.WordsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WordsService {

    private static final Logger log = LoggerFactory.getLogger(WordsService.class);

    private WordsRepository repository;

    @Autowired
    private LicensesService licenses;

    /** WORD LIST ALL **/
    public List<WordDTO> findAll( ) { 

        List<WordDTO> list = new ArrayList<>();

        repository.findAll().forEach( x -> { 
            list.add( new WordDTO(x, licenses.findById(3)));
        }); 
        return list;
    } 

    /** WORD INSERT **/
    @Transactional
    public void wordInsert ( Word vo ){ 
        repository.save(vo);
    }
}
