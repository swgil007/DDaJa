package com.bng.ddaja.words.controller;

import java.util.List;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.service.WordsService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping
@RestController
public class WordsController {

    private WordsService service;
    private LicensesService lService;

    @GetMapping("/words")
    @ResponseBody
    public List<WordDTO> wordAllList ( ){
    
        return service.findAll();
    }

    @PostMapping("/words")
    public ResponseEntity<String> wordInsert (  @RequestParam( name = "title", required = false ) String title,
                                                @RequestParam( name = "lid", required = false )   long lid ){
                                                
        
        Word vo = Word.builder()
                        .license( lService.findById(lid) )
                        .title(title)
                        .build();

        service.wordInsert(vo);

        return ResponseEntity.ok().body("INSERT SECCESS : )");
    }
}
