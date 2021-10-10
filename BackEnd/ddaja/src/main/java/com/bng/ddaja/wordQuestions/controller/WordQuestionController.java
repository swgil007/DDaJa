package com.bng.ddaja.wordQuestions.controller;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RequestMapping("/word-questions")
@AllArgsConstructor
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


    @PostMapping("")
    public @ResponseBody ResponseEntity<CommonResponse> saveWordQuestion( @Valid WordQuestionDTO wordQuestionDTO ){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordQuestionService.saveWordQuestion(wordQuestionDTO)
            )
        );
    }


    @PutMapping("{id}")
    public ResponseEntity<CommonResponse> updateWordQuestion( @PathVariable(name="id", required = true) long id, @Valid WordQuestionDTO wordQuestionDTO){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordQuestionService.saveWordQuestion(wordQuestionDTO)
            )
        );
    }


    /*
    ** Access-Control-Allow-Origin: '*' CROS ERROR 발생. 해결 예정.
    */
    @DeleteMapping("{id}")
    public ResponseEntity<CommonResponse> deleteWordQuestion(@PathVariable(name="id", required = true) long id){
        return ResponseEntity.ok().body(
            new CommonResponse(
                wordQuestionService.deleteWordQuestion(id)
            )
        );
    }
}