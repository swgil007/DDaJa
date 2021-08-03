package com.bng.ddaja.licenses.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.licenses.service.LicensesService;
import com.bng.ddaja.test.dto.LicenseDTO;

import org.springframework.http.ResponseEntity;
import com.bng.ddaja.common.dto.CommonError;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
//import com.bng.ddaja.licenses.dto.LicenseDTO;
import com.bng.ddaja.common.hateos.licenses.Licenses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("licenses")
@RestController
public class LicensesController {
    
    private LicensesService licenseService;

    @ApiOperation(
        value = "자격증 전체 조회"
        , notes = "전체 자격증 목록을 조회한다")
    @GetMapping("")
    public ResponseEntity<CommonResponse<LicenseDTO>> getLicenses() {
        List<LicenseDTO> licenseList = licenseService.getAllLicenses();
        List<CommonResource<LicenseDTO>> resourceList = licenseList.stream()
                                                                    .map(dto -> new CommonResource<>(dto, 
                                                                    Arrays.stream(Licenses.values()).map(e -> e.initLink(dto.getId())).collect(Collectors.toList())
                                                                        ))
                                                                    .collect(Collectors.toList());
        return ResponseEntity.ok().body(new CommonResponse<>(resourceList.size(), resourceList));
    }

    @ApiOperation(
        value = "특정 자격증 조회"
        , notes = "자격증 ID를 통해 특정 자격증의 정보를 조회한다.")
    // @ApiImplicitParams({
    //     @ApiImplicitParam(
    //         name = "seq"
    //         , value = "자격증 시퀀스"
    //         , defaultValue = ""
    //     )
    //     , @ApiImplicitParam(
    //         name = "fields"
    //         , value = "요청 데이터 필드 값"
    //         , defaultValue = ""
    //     )
    //     , @ApiImplicitParam(
    //         name = "page"
    //         , value = "요청 데이터 페이지"
    //     )
    //     , @ApiImplicitParam(
    //         name = "perPage"
    //         , value = "요청 데이터 페이지 당 데이터 수"
    //     )
    // })
    @GetMapping("/{id}")
    public ResponseEntity<CommonResource<LicenseDTO>> getLicenses(@PathVariable(name = "id", required = true) long id) {
        LicenseDTO license = licenseService.getLicenseById(id);
        CommonResource<LicenseDTO> resource = new CommonResource<>(license, Arrays.stream(Licenses.values()).map(e -> e.initLink(license.getId())).collect(Collectors.toList()));
        return ResponseEntity.ok().body(resource);
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
    
}
