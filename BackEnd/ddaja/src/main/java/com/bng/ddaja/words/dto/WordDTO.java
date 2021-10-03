package com.bng.ddaja.words.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.domain.WordQuestion;
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

    @ApiModelProperty(
        name = "wordQuestionCount"
    )
    private int wordQuestionsCount;

    public WordDTO( Word word ){

        id                 = word.getId();
        title              = word.getTitle();
        createdDate        = word.getCreatedDate();
        modifiedDate       = word.getModifiedDate();
        license            = new LicenseDTO(word.getLicense());

        Optional<List<WordQuestion>> op = Optional.ofNullable(word.getWordQuestions());
        if(op.isPresent()){
            wordQuestionsCount = op.get().size();
        }else{
            wordQuestionsCount = 0;
        }
    }

    public Word toEntity( ){
        return Word.builder()
            .title(this.title)
            .build();
    }
}
