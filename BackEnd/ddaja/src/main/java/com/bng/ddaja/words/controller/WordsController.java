package com.bng.ddaja.words.controller;

import java.util.List;

import com.bng.ddaja.common.domain.Word; 
import com.bng.ddaja.words.service.WordsService;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("words")
@RestController
public class WordsController {

    private WordsService service;

    @GetMapping("/words")
    @ResponseBody
    public List<Word> wordAllList ( ){
    
        return service.findAll();
    }
}
