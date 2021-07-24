package com.bng.ddaja.wordQuestions.controller;

import java.util.List;

import com.bng.ddaja.common.domain.WordQuestion;
import com.bng.ddaja.wordQuestions.service.WordQuestionService;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("word-questions")
@RestController
public class WordQuestionController {
    
    private WordQuestionService service;

    @GetMapping("/word-questions")
    @ResponseBody
    public List<WordQuestion> wordQuestionAllList(){

        return service.findAll();
    }
}
