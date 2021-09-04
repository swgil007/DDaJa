package com.bng.ddaja.words.controller;

import java.util.List;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.temp.license.TempLicensesService;
import com.bng.ddaja.test.dto.LicenseDTO;
import com.bng.ddaja.words.dto.WordDTO;
import com.bng.ddaja.words.service.WordService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RequestMapping("words")
@RestController
public class WordController {

    private WordService wordService;
    private TempLicensesService licenseService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<CommonResponse> wordList(   ){
        
        List<CommonResource> resourceList = wordService.findAll().stream().map(dto -> new CommonResource(dto)).collect(Collectors.toList());
        return ResponseEntity.ok() 
                            .body( new CommonResponse(resourceList.size(), resourceList) );
    }





// 자격증 id 
// 해당 자격증 id 에 word List 를 반환


// words ? lid = 1
// licenses / lid / words



    @GetMapping("/words/licenses/{lid}")
    @ResponseBody
    public ResponseEntity<List<WordDTO>> wordLicenseList ( @PathVariable(name = "lid", required = true) long lid ){

        return ResponseEntity.ok()
                            .body(wordService.wordLicenseList(lid));
    }
























    @PostMapping("/words")
    public ResponseEntity<String> wordInsert (  @RequestParam( name = "title", required = false ) String title,
                                                @RequestParam( name = "lid"  , required = false ) long lid ){                                           

     //    wordService.wordInsert(new  Word);

        return ResponseEntity.ok().body("INSERT SECCESS : )");
    }
}