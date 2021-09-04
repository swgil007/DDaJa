package com.bng.ddaja.licenses.controller;

import java.util.List;

import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.licenses.spec.LicenseSearchOptions;

import org.springframework.http.ResponseEntity;

import com.bng.ddaja.common.dto.CommonError;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.enums.LicenseCode;
import com.bng.ddaja.common.enums.LicenseType;
import com.bng.ddaja.licenses.dto.LicenseDTO;
import com.bng.ddaja.licenses.dto.LicenseSearch;
import com.bng.ddaja.common.hateoas.licenses.LicenseHateoas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RequestMapping("licenses")
@RestController
public class LicensesController {
    
    private LicensesService licenseService;

    @ApiOperation(
        value = "자격증 전체 조회"
        , notes = "전체 자격증 목록을 조회한다"
        , produces = "application/json"
        , response = CommonResponse.class
    )
    @GetMapping("")
    public ResponseEntity<CommonResponse> getLicenses(LicenseSearch licenseSearch) {
        return ResponseEntity.ok().body(
                new CommonResponse(
                    licenseService.getAllLicenseByLicenseSearch(licenseSearch)
                    , LicenseHateoas.values()
                )
            );
    }

    @ApiOperation(
        value = "특정 자격증 조회"
        , notes = "자격증 ID를 통해 특정 자격증의 정보를 조회한다.")
    @GetMapping("/{id}")
    public ResponseEntity<CommonResource> getLicenses(@PathVariable(name = "id", required = true) long id) {
        return ResponseEntity.ok().body(new CommonResource(licenseService.getLicenseById(id), LicenseHateoas.values()));
    }

    @ApiOperation(
        value = "특정 자격증 수정"
        , notes = "자격증 ID를 통해 특정 자격증의 정보를 수정한다.")
    @PutMapping("/{id}")
    public ResponseEntity<CommonResource> putLicenses(@PathVariable(name = "id", required = true) long id, @RequestBody LicenseDTO licenseDTO) {
        return ResponseEntity.ok().body(new CommonResource(licenseService.saveLicense(licenseDTO), LicenseHateoas.values()));
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
    public ResponseEntity<LicenseDTO> createLicenses(@RequestBody LicenseDTO licenseDTO) {
        LicenseDTO savedLicense = licenseService.saveLicense(licenseDTO);
        return ResponseEntity.ok().body(savedLicense);
    }
    
    @GetMapping("type")
    public ResponseEntity<CommonResponse> getLicensesType() {
        return ResponseEntity.ok().body(new CommonResponse(LicenseType.values()));
    }

    @GetMapping("code")
    public ResponseEntity<CommonResponse> getLicensesCode() {
        return ResponseEntity.ok().body(new CommonResponse(LicenseCode.values())); 
    }

    @GetMapping("subjects")
    public ResponseEntity<List<LicenseDTO>> getSubjectCollections(LicenseSearch licenseSearch) {
        return ResponseEntity.ok().body(licenseService.getAllLicenseLikeSubjectName(licenseSearch));   
    }

    @ApiOperation(
        value = "자격증 검색조건 조회"
        , notes = "자격증 검색 조건 목록을 조회한다"
        , produces = "application/json"
        , response = CommonResponse.class
    )
    @GetMapping("search")
    public ResponseEntity<CommonResponse> getLicenseSearchOptions() {
        return ResponseEntity.ok().body(new CommonResponse(LicenseSearchOptions.values()));
    }
}
