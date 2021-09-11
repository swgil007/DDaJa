package com.bng.ddaja.words.controller;


import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.hateoas.word.WordHateoas;
import com.bng.ddaja.words.dto.WordSearch;
import com.bng.ddaja.words.service.WordService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RequestMapping("words")
@RestController
public class WordController {

    private WordService wordService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<CommonResponse> getAllWordByWordSearch( WordSearch wordSearch ){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordService.getAllWordByWordSearch(wordSearch)
                , WordHateoas.values()
            )
        );
    }

    @GetMapping("/total-count")
    @ResponseBody
    public ResponseEntity<CommonResponse> getAllWordByWordSearchTotalCount( WordSearch wordSearch ){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordService.getAllWordByWordSearchTotalCount(wordSearch)
            )
        );
    }

    @PostMapping("")
    public ResponseEntity<String> createWord (  @RequestParam( name = "title", required = false ) String title,
                                                @RequestParam( name = "lid"  , required = false ) long lid ){                                           

       // wordService.createWord(new  Word);

        return ResponseEntity.ok().body("INSERT SECCESS : )");
    }
}