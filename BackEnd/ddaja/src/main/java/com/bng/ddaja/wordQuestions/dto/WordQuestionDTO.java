package com.bng.ddaja.wordQuestions.dto;

import com.bng.ddaja.common.domain.WordQuestion;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.words.dto.WordDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordQuestionDTO extends CommonDTO{

    @ApiModelProperty(
        name = "id"
        , example = "11"
    )
    private long id;

    @ApiModelProperty(
        name = "content"
        , example = "~~ 란 ?"
    )
    private String content;

    @ApiModelProperty(
        name = "answer"
        , example = "운영체제"
    )
    private String answer;

    @ApiModelProperty(
        name = "lId"
        , example = "11"
    )
    private long lId;

    @ApiModelProperty(
        name = "WordDTO"
        , example = "11"
    )
    private WordDTO wordDTO;


    public WordQuestionDTO( WordQuestion wordQuestion ){
        this.id      = wordQuestion.getId();
        this.wordDTO = new WordDTO(wordQuestion.getWord());
        this.lId     = wordQuestion.getLId();
        this.content = wordQuestion.getContent();
        this.answer  = wordQuestion.getAnswer();
    }

    public WordQuestion toEntity( ){

        return WordQuestion.builder()
        .id(this.id)
        .content(this.content)
        .answer(this.answer)
        .lId(this.lId)
        .build();
    }
}
