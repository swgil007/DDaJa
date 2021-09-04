package com.bng.ddaja.words.service;

import java.util.ArrayList;
import java.util.List;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.temp.license.TempLicensesService;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.repository.WordsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class WordsService {

    private WordsRepository repository;

    @Autowired
    private TempLicensesService licenses;

    /** WORD LIST - ALL **/
    public List<WordDTO> findAll( ) { 
        return repository.findAll().stream().map(vo -> new WordDTO(vo)).collect(Collectors.toList());
    } 

    /** WORD LIST - LICENSES **/
    public List<WordDTO> wordLicenseList( long lid ) { 

        List<WordDTO> list = new ArrayList<>();

        License vo = License.builder().id( lid ).build(); 

        repository.findByLicense( vo ).forEach( x -> { 
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
