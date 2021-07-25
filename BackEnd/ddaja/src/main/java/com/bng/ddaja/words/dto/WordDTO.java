package com.bng.ddaja.words.dto;

import java.util.ArrayList;
import java.util.List;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.domain.Word;
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
        name = "title"
        , example = "리눅스 용어 외우기"
    )
    private String title;

    @ApiModelProperty(
        name = "License Entity"
    )
    private License license;

    @ApiModelProperty(
        name = "WordQuestion Entity"
    ) 
    private List<WordQuestionDTO> wordQuestions = new ArrayList<WordQuestionDTO>();

    public WordDTO( Word word ){
        this.wId = word.getId();
        // this.license = word.getLicense();
        this.title =  word.getTitle(); 

        word.getWordQuestions().forEach(x-> {
            this.wordQuestions.add( new WordQuestionDTO(x) );
        });
    }
}
