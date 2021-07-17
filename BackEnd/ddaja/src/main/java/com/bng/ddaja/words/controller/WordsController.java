package com.bng.ddaja.words.controller;

import com.bng.ddaja.words.service.WordsService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("words")
@RestController
public class WordsController {
    private WordsService wordsService ;

}
