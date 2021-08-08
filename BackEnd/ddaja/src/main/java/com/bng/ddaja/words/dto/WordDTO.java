package com.bng.ddaja.words.dto;

import java.util.ArrayList;
import java.util.List;

import com.bng.ddaja.common.domain.Word;
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
public class WordDTO { 

    @ApiModelProperty(
        name = "w_id"
        , example = "11"
    )
    private long wId;
    
    @ApiModelProperty(
        name = "l_id"
        , example = "11"
    )
    private long lId;

    @ApiModelProperty(
        name = "title"
        , example = "리눅스 용어 외우기"
    )
    private String title;

    @ApiModelProperty(
        name = "LicenseDTO"
    )
    private LicenseDTO licenseDTO;

    @ApiModelProperty(
        name = "WordQuestion Entity"
    ) 
    private List<WordQuestionDTO> wordQuestions = new ArrayList<WordQuestionDTO>();

    public WordDTO( Word word ){

        this.wId = word.getId();
        this.title =  word.getTitle();
        this.licenseDTO = new LicenseDTO(word.getLicense());
        // word.getWordQuestions().forEach(x-> {
        //     this.wordQuestions.add( new WordQuestionDTO(x) );
        // }); 
    }

    public WordDTO( Word word , LicenseDTO licenseDTO ) {

        this.wId     = word.getId();
        this.title   = word.getTitle();
        this.licenseDTO = licenseDTO;
        
        // word.getWordQuestions().forEach(x-> {
        //     this.wordQuestions.add( new WordQuestionDTO(x) );
        // }); 
    }
}
