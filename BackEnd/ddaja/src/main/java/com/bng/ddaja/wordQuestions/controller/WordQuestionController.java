package com.bng.ddaja.wordQuestions.controller;

import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.hateoas.wordQuestion.WordQuestionHateoas;
import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.dto.WordQuestionSearch;
import com.bng.ddaja.wordQuestions.service.WordQuestionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

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

    @PutMapping("")
    public ResponseEntity<CommonResponse> saveWordQuestion(  @ApiParam(  name = "content", type = "String", required = true) @RequestParam("content") String content 
                                                            , @ApiParam( name = "answer" , type = "String", required = true) @RequestParam("answer")  String answer 
                                                            , @ApiParam( name = "lID"    , type = "long"  , required = true) @RequestParam("lID")     long lID 
                                                            , @ApiParam( name = "wID"    , type = "long"  , required = true) @RequestParam("wID")     long wID){

        WordQuestionDTO wordQuestionDTO = new WordQuestionDTO();
        wordQuestionDTO.setLId(lID);
        wordQuestionDTO.setAnswer(answer);
        wordQuestionDTO.setContent(content);

        return ResponseEntity.ok().body(
            new CommonResponse(
                wordQuestionService.saveWordQuestion(wordQuestionDTO, wID)
            )
        );
    }


    @PostMapping("/{id}")
    public ResponseEntity<CommonResponse> updateWordQuestion( @PathVariable(name="id", required = true) long id
                                    , @ApiParam( name = "content", type = "String", required = true) @RequestParam("content") String content 
                                    , @ApiParam( name = "answer" , type = "String", required = true) @RequestParam("answer")  String answer 
                                    , @ApiParam( name = "lID"    , type = "long"  , required = true) @RequestParam("lID")     long lID 
                                    , @ApiParam( name = "wID"    , type = "long"  , required = true) @RequestParam("wID")     long wID ){

        WordQuestionDTO wordQuestionDTO = new WordQuestionDTO();
        wordQuestionDTO.setAnswer(answer);
        wordQuestionDTO.setLId(lID);
        wordQuestionDTO.setId(id);
        wordQuestionDTO.setContent(content);

        return ResponseEntity.ok().body(
                    new CommonResponse(
                        wordQuestionService.saveWordQuestion(wordQuestionDTO, wID)
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