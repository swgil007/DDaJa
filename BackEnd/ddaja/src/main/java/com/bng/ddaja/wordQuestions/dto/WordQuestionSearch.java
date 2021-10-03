package com.bng.ddaja.wordQuestions.dto;

import com.bng.ddaja.common.domain.WordQuestion;
import com.bng.ddaja.common.dto.CommonSearch;
import com.bng.ddaja.common.spec.SpecBuilder;
import org.springframework.data.jpa.domain.Specification;
import static com.bng.ddaja.wordQuestions.spec.WordQuestionSpec.*;
import static org.springframework.data.jpa.domain.Specification.where;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WordQuestionSearch extends CommonSearch {
    
    private long wordID;

    @Override
    public Specification<WordQuestion> toSpecification(){
        return SpecBuilder.builder(WordQuestion.class)
        .addSpec(where(equalWordID(wordID)))
        .toSpecification();
    }
}