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

    @ApiModelProperty(
        name = "wordQuestionCount"
    )
    private int wordQuestionsCount;

    @ApiModelProperty(
        name = "userWordQuestioinAnswerCount"
    )
    private int userWordQuestionAnswerCount;

    public WordDTO( Word word ){

        id                 = word.getId();
        title              = word.getTitle();
        createdDate        = word.getCreatedDate();
        modifiedDate       = word.getModifiedDate();
        wordQuestionsCount = word.getWordQuestions().size();
        license            = new LicenseDTO(word.getLicense());

        /** User API 개발 후 수정 - user 가 해당 단어 목록 정답률 **/
        userWordQuestionAnswerCount = word.getWordQuestions().size() / 3;
    }
}
