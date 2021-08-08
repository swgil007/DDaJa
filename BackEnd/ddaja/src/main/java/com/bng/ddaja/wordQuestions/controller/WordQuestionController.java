package com.bng.ddaja.wordQuestions.controller;

import java.util.List;

import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.service.WordQuestionService;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<WordQuestionDTO>> wordQuestionAllList(){

        return ResponseEntity.ok() 
                            .body(service.findAll());
    }

    @GetMapping("/wId/{wid}")
    @ResponseBody
    public ResponseEntity<List<WordQuestionDTO>> wordQuestionAllList2( @PathVariable(name = "wid", required = true) long wid ){

        return ResponseEntity.ok() 
                            .body(service.findByWId(wid));
    }

    @GetMapping("/{wqid}")
    @ResponseBody
    public ResponseEntity<WordQuestionDTO> wordQuestionAllList1( @PathVariable(name = "wqid", required = true) long wqid ){

        return ResponseEntity.ok() 
                            .body(service.findById(wqid)); 
    }
}