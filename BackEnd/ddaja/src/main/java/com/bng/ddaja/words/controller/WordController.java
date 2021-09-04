package com.bng.ddaja.words.controller;

import java.util.List;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.hateoas.word.WordHateoas;
import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.temp.license.TempLicensesService;
import com.bng.ddaja.test.dto.LicenseDTO;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.dto.WordSearch;
import com.bng.ddaja.words.service.WordService;

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
@RequestMapping("words")
@RestController
public class WordController {

    private WordService wordService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<CommonResponse> wordList( WordSearch wordSearch ){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordService.getAllWordByWordSearch(wordSearch)
                , WordHateoas.values()
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