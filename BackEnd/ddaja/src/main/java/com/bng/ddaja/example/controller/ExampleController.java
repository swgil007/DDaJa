package com.bng.ddaja.example.controller;

import javax.validation.Valid;

import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.example.dto.UserDTO;
import com.bng.ddaja.example.service.UserService;
import com.bng.ddaja.test.dto.TestParameter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@RequestMapping("/example")
@AllArgsConstructor
@ApiIgnore
@RestController
public class ExampleController {

    private UserService userService;

    @ApiOperation(
        value = "사용자 정보 조회"
        , notes = "사용자의 ID를 통해 사용자의 정보를 조회한다.")
    @ApiImplicitParam(
        name = "id"
        , value = "사용자 아이디"
        , required = true
        , dataType = "string"
        , paramType = "path"
        , defaultValue = "None")
    @GetMapping("/user/{userId}")
    public UserDTO getUser(@PathVariable(name = "userId") String userId) {
        return userService.findUserInfoByUserId(userId);
    }

    @GetMapping("/users/{id}")
    public User getUserByUId(@PathVariable(name = "id") long uId) {
        return userService.findUserInfoByUId(uId);
    }

    // @GetMapping("/users/{uId}")
    // @ResponseBody
    // public UserDTO getUser(@PathVariable(name = "uId") long uId) {
    //     return userService.findUser(uId);

    // }

    @ApiOperation(
        value = "자격증 정보 조회"
        , notes = "자격증의 ID를 통해 자격증의 정보를 조회한다.")
    @ApiImplicitParams(
        {
            @ApiImplicitParam(
                name           = "id"
                , value        = "자격증 아이디"
                , required     = true
                , dataType     = "string"
                , paramType    = "path"
                , defaultValue = "None"
            )
        ,
            @ApiImplicitParam(
                name           = "fields"
                , value        = "응답 필드 종류"
                , required     = false
                , dataType     = "string"
                , paramType    = "query"
                , defaultValue = ""
            )
        })
    @GetMapping("/licenses/{id}")
    public UserDTO getLicense(@PathVariable(name = "id") String id, @RequestParam(name = "fields", required = false) String fields) {
        return null;
    }

    @ApiResponses({
        @ApiResponse(code = 200, message = "성공입니다.")
        , @ApiResponse(code = 400, message = "접근이 올바르지 않습니다.")
    })
    @GetMapping("/notices/{id}")
    public String getNotice(UserDTO userDTO) {
        return "notice";
    }

    @GetMapping("/debates/{id}")
    public String getDebate(@ApiParam(value = "토론 ID") @PathVariable(name = "id") String id) {
        return "debate";
    }

    @PostMapping("/valid")
    public String valid(@Valid @RequestBody TestParameter parameter ) {
        return "ResponseEntity.ok().body(body success);";
    }
}
