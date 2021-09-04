package com.bng.ddaja.words.dto;

import com.bng.ddaja.common.domain.Word;
import com.bng.ddaja.common.dto.CommonSearch;
import com.bng.ddaja.common.spec.SpecBuilder;
import static com.bng.ddaja.words.spec.WordSpec.*;
import static org.springframework.data.jpa.domain.Specification.where;

import org.springframework.data.jpa.domain.Specification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WordSearch extends CommonSearch {
    
    /****************************************************************************
    *****************************************************************************
    ** WordSearch 의 목적
    ** - Controller - Service - Vo
    ** - 표현계층의 역활 >> 데이터 검증, 매핑, 어떤 컨트롤러 매핑, 어떤 서비스 매칭, 
    ** - 뒷단 생각 ㄴㄴ
    ** - 어떤 검색 조건으로 ~~~~~~~~~~~~~~~~~~~~~~~~~ ???
    ** - 필드명은 사용자가 직독직해 하게끔
    *****************************************************************************
    *****************************************************************************/

    private String name;
    private long licenseID;

    @Override
    public Specification<Word> toSpecification() {
        return SpecBuilder.builder(Word.class)
                            .addSpec(where(nameLike(name)))
                            .addSpec(where(equalLicenseID(licenseID)))
                            .toSpecification();
    } 
}