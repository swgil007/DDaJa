package com.bng.ddaja.test.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.common.dto.CommonParameter;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.dto.Link;
import com.bng.ddaja.common.hateos.licenses.Licenses;
import com.bng.ddaja.example.dto.UserDTO;
import com.bng.ddaja.example.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("test")
@AllArgsConstructor
public class TestController {
    
    private UserService userService;
    
    @GetMapping("")
    @ResponseBody
    public String test() {
        return "test";
    }

    @GetMapping("/one/{id}")
    @ResponseBody
    public List<Link> one(@PathVariable(name = "id") Long id) {
        return Licenses.SELF.makeLinkList(id);
    }

    @GetMapping("/two/{id}")
    @ResponseBody
    public List<Link> two(@PathVariable(name = "id") Long id) {
        return Arrays.stream(Licenses.values()).map(e -> new Link(e.name(), e.url+id.toString(), e.method)).collect(Collectors.toList());
    }

    @GetMapping("/three")
    @ResponseBody
    public CommonResponse<UserDTO> three(CommonParameter parameter) {
        return userService.findUserListByParameter(parameter);        
    }

    @GetMapping("/four")
    @ResponseBody
    public CommonParameter four(CommonParameter parameter) {
        return parameter;
    }

    @GetMapping("/five")
    @ResponseBody
    public ResponseEntity<CommonResponse<UserDTO>> five() {
        UserDTO userDTO = new UserDTO(Integer.toUnsignedLong(11), "test", "김텟트");
        CommonResponse<UserDTO> response = new CommonResponse<UserDTO>(1, new CommonResource<UserDTO>(userDTO, null));
        return new ResponseEntity<>(response, null, HttpStatus.OK);
    }
}
