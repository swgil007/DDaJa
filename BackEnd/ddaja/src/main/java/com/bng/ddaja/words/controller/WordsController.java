package com.bng.ddaja.words.controller;

import java.util.List;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.temp.license.TempLicensesService;
import com.bng.ddaja.test.dto.LicenseDTO;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.service.WordsService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RequestMapping
@RestController
public class WordsController {

    private WordsService service;
    private TempLicensesService license;

    // @GetMapping("/words")
    // @ResponseBody
    // public ResponseEntity<CommonResponse<WordDTO>> wordAllList( ){
    //     List<CommonResource<WordDTO>> resourceList = service.findAll().stream().map(dto -> new CommonResource<>(dto, null)).collect(Collectors.toList());
    //     return ResponseEntity.ok() 
    //                         .body( new CommonResponse<>(resourceList.size(), resourceList) );
    // }

    @GetMapping("/words/{wid}")
    @ResponseBody
    public ResponseEntity<List<WordDTO>> wordList( @PathVariable(name = "lid", required = true) long lid
                                                    , @RequestParam( name = "startNumber", required = false ) int startNumber 
                                                    , @RequestParam( name = "limitNumber", required = false ) int limitNumber 
                                                    , @RequestParam( name = "sortEntity", required = false ) String sortEntity ){

        // return ResponseEntity.ok() 
        //                     .body(service.findAll());
        return null;
    }

    @GetMapping("/words/licenses/{lid}")
    @ResponseBody
    public ResponseEntity<List<WordDTO>> wordLicenseList ( @PathVariable(name = "lid", required = true) long lid ){

        return ResponseEntity.ok()
                            .body(service.wordLicenseList(lid));
    }

    @PostMapping("/words")
    public ResponseEntity<String> wordInsert (  @RequestParam( name = "title", required = false ) String title,
                                                @RequestParam( name = "lid"  , required = false ) long lid ){                                           

        Word vo = Word.builder()
                        .license(new LicenseDTO().licenseToDto(license.findById(lid)))
                        .title(title)
                        .build();

        System.out.println("------------??" );
        System.out.println(vo.getLicense().getId());
        System.out.println("------------??" + vo.getCreatedDate());
        
        service.wordInsert(vo);

        return ResponseEntity.ok().body("INSERT SECCESS : )");
    }
}