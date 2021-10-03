package com.bng.ddaja.words.controller;


import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.hateoas.word.WordHateoas;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.dto.WordSearch;
import com.bng.ddaja.words.service.WordService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
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
    public ResponseEntity<CommonResponse> saveWord (@ApiParam(   name = "lID"   , type = "long"   , required = true) @RequestParam("lID")   long lID 
                                                    , @ApiParam( name = "title" , type = "String" , required = true) @RequestParam("title") String title ){                                           

        WordDTO wordDTO = new WordDTO();
        wordDTO.setTitle(title);
        
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordService.saveWord(wordDTO, lID)
            )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateWord ( @PathVariable(name="id", required = true) long id
                                    , @ApiParam( name = "lID"   , type = "long"   , required = true) @RequestParam("lID")   long lID 
                                    , @ApiParam( name = "title" , type = "String" , required = true) @RequestParam("title") String title  ){                                           

        WordDTO wordDTO = new WordDTO();
        wordDTO.setId(id);
        wordDTO.setTitle(title);
        
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordService.saveWord(wordDTO, lID)
            )
        );
    }
}