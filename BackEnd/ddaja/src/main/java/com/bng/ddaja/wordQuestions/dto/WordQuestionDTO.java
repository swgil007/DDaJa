package com.bng.ddaja.wordQuestions.dto;

import com.bng.ddaja.common.domain.WordQuestion;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordQuestionDTO {

    @ApiModelProperty(
        name = "wq_id"
        , example = "11"
    )
    private long wqId;

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
        name = "l_id"
        , example = "11"
    )
    private long lId;

    public WordQuestionDTO( WordQuestion wordQuestion ){
        this.wqId    = wordQuestion.getId();
        this.content = wordQuestion.getContent();
        this.answer  = wordQuestion.getAnswer();
        this.lId     = wordQuestion.getLId();
    }
}
