package com.bng.ddaja.wordQuestions.controller;

import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.hateoas.wordQuestion.WordQuestionHateoas;
import com.bng.ddaja.wordQuestions.dto.WordQuestionSearch;
import com.bng.ddaja.wordQuestions.service.WordQuestionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/word-questions")
@RestController
public class WordQuestionController {
    
    private WordQuestionService wordQuestionService;

    @GetMapping("")
    public ResponseEntity<CommonResponse> getAllWordQuestionByWordQuestionSearch( WordQuestionSearch wordQuestionSearch ){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordQuestionService.getAllWordQuestionByWordQuestionSearch(wordQuestionSearch)
                , WordQuestionHateoas.values()
            )
        );
    }
}