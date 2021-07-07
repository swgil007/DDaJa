package com.bng.ddaja.example.controller;

import com.bng.ddaja.example.dto.UserDTO;
import com.bng.ddaja.example.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/example")
@AllArgsConstructor
@ApiIgnore
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
    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDTO getUser(@PathVariable(name = "id") String id) {
        return userService.findUserInfoById(id);
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
                name = "id"
                , value = "자격증 아이디"
                , required = true
                , dataType = "string"
                , paramType = "path"
                , defaultValue = "None"
            )
        ,
            @ApiImplicitParam(
                name = "fields"
                , value = "응답 필드 종류"
                , required = false
                , dataType = "string"
                , paramType = "query"
                , defaultValue = ""
            )
        })
    @GetMapping("/licenses/{id}")
    @ResponseBody
    public UserDTO getLicense(@PathVariable(name = "id") String id, @RequestParam(name = "fields", required = false) String fields) {
        return userService.findUserInfoById(id);
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
}
