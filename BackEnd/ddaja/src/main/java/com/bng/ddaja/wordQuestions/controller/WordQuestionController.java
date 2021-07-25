package com.bng.ddaja.wordQuestions.controller;

import java.util.List;

import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.service.WordQuestionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/word-questions")
@RestController
public class WordQuestionController {
    
    private WordQuestionService service;

    @GetMapping("")
    @ResponseBody
    public List<WordQuestionDTO> wordQuestionAllList(){

        return service.findAll();
    }

    @GetMapping("/{wqId}")
    @ResponseBody
    public WordQuestionDTO wordQuestionAllList1( @PathVariable(name = "wqId", required = true) long wqId ){

        return service.findById(wqId);
    }

    @GetMapping("/wid/{wId}")
    @ResponseBody
    public List<WordQuestionDTO> wordQuestionAllList2( @PathVariable(name = "wId", required = true) long wId ){

        return service.findByWId(wId);
    }
}
