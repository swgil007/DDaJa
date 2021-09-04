package com.bng.ddaja.words.dto;

import java.util.ArrayList;
import java.util.List;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.test.dto.LicenseDTO;
import com.bng.ddaja.wordQuestions.dto.WordQuestionDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordDTO extends CommonDTO { 

    @ApiModelProperty(
        name = "title"
        , example = "리눅스 용어 외우기"
    )
    private String title;

    @ApiModelProperty(
        name = "License"
    )
    private LicenseDTO license;

    @ApiModelProperty(
        name = "WordQuestion Entity"
    ) 
    private List<WordQuestionDTO> wordQuestions = new ArrayList<WordQuestionDTO>();

    public WordDTO( Word word ){

        id = word.getId();
        title =  word.getTitle();
        license = new LicenseDTO(word.getLicense());
        // word.getWordQuestions().forEach(x-> {
        //     this.wordQuestions.add( new WordQuestionDTO(x) );
        // }); 
    }

    public WordDTO( Word word , LicenseDTO licenseDTO ) {

        id     = word.getId();
        title   = word.getTitle();
        license = licenseDTO;
        
        // word.getWordQuestions().forEach(x-> {
        //     this.wordQuestions.add( new WordQuestionDTO(x) );
        // }); 
    }
}
