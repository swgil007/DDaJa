package com.bng.ddaja.wordQuestions.controller;

import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.hateoas.wordQuestion.WordQuestionHateoas;
import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.dto.WordQuestionSearch;
import com.bng.ddaja.wordQuestions.service.WordQuestionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> saveWordQuestion(@RequestBody WordQuestionDTO wordQuestionDTO){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordQuestionService.saveWordQuestion(wordQuestionDTO)
            )
        );
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<CommonResponse> updateWordQuestion(@PathVariable(name="id", required = true) long id, @RequestBody WordQuestionDTO wordQuestionDTO){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordQuestionService.updateWordQuestion(wordQuestionDTO, id)
            )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteWordQuestion(@PathVariable(name="id", required = true) long id){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordQuestionService.deleteWordQuestion(id)
            )
        );
    }
}