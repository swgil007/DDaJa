package com.bng.ddaja.wordQuestions.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.http.*;

import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;
import com.bng.ddaja.wordQuestions.service.WordQuestionService;

import org.springframework.http.HttpStatus;
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

    @GetMapping("/wId/{wId}")
    @ResponseBody
    public ResponseEntity<List<WordQuestionDTO>> wordQuestionAllList2( @PathVariable(name = "wId", required = true) long wId ){

        return ResponseEntity.ok() 
                            .body(service.findByWId(wId));
    }

    @GetMapping("/{wqId}")
    @ResponseBody
    public ResponseEntity<WordQuestionDTO> wordQuestionAllList1( @PathVariable(name = "wqId", required = true) long wqId ){

        return ResponseEntity.ok() 
                            .body(service.findById(wqId)); 
    }
}