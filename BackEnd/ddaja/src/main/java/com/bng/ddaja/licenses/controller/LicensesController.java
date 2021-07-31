package com.bng.ddaja.licenses.controller;

import java.util.List;

import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.test.dto.LicenseDTO;

import org.springframework.http.ResponseEntity;
import com.bng.ddaja.common.dto.CommonError;
import com.bng.ddaja.common.dto.CommonResponse;
//import com.bng.ddaja.licenses.dto.LicenseDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
 
@AllArgsConstructor
@RequestMapping
@RestController
public class LicensesController {
    
    private LicensesService service;

    /*
    * TEST 중 입니다.
    * - 실행 실패.
    */
    @GetMapping("/licenses")
    public ResponseEntity<List<LicenseDTO>> getLicenses() { 
        return ResponseEntity.ok() 
                            .body(service.findAll());
    }

    @GetMapping("/licenses/{lid}")
    public ResponseEntity<LicenseDTO> getLicensess( @PathVariable(name = "lid", required = true) long lid ) { 
        return ResponseEntity.ok() 
                            .body(service.findById(lid));
    }

    /*
    @PostMapping("")

@AllArgsConstructor
@RequestMapping("licenses")
@RestController
public class LicensesController {
    
    @ApiOperation(
        value = "자격증 전체 조회"
        , notes = "전체 자격증 목록을 조회한다")
    @GetMapping("")
    public String getLicenses() {
        return "getLicenses";
    }

    @ApiOperation(
        value = "신규 자격증 생성"
        , notes = "신규 자격증을 생성한다."
        , produces = "application/json"
        , response = CommonResponse.class
    )
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "requestDTO"
            , value = "생성을 위해 필요한 Requeest Body"
        )
    })
    @ApiResponses({
        @ApiResponse(
            code = 201
            , message = "생성된 자원 정보"
            , response = CommonResponse.class
            , responseContainer = "List"
        )
        , @ApiResponse(
            code = 409
            , message = "로직 수행 불가 모순 발생"
            , response = CommonError.class
            , responseContainer = "List"
        )
    })
    @PostMapping("")
    public String postLicenses(@RequestBody LicenseDTO licenseDTO) {
        return "string";
    }
    
    @ApiOperation(
        value = "특정 자격증 조회"
        , notes = "자격증 시퀀스를 통해 특정 자격증의 정보를 조회한다.")
    @ApiImplicitParams({
        @ApiImplicitParam(
            name = "seq"
            , value = "자격증 시퀀스"
            , defaultValue = ""
        )
        , @ApiImplicitParam(
            name = "fields"
            , value = "요청 데이터 필드 값"
            , defaultValue = ""
        )
        , @ApiImplicitParam(
            name = "page"
            , value = "요청 데이터 페이지"
        )
        , @ApiImplicitParam(
            name = "perPage"
            , value = "요청 데이터 페이지 당 데이터 수"
        )
    })
    @GetMapping("/{seq}")
    public String getLicenses(
        @PathVariable(name = "seq", required = true) long seq
        , @RequestParam(name = "fields", required = false) String fields
        , @RequestParam(name = "page", required = false) int page
        , @RequestParam(name = "per-page", required = false) int perPage) {
        return "getLicenses";
    }
    */
}
