package com.bng.ddaja.test.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.bng.ddaja.common.dto.CommonError;
import com.bng.ddaja.common.dto.CommonErrorDetail;
import com.bng.ddaja.common.dto.CommonParameter;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.dto.Link;
import com.bng.ddaja.common.error.exception.MemberNotFoundException;
import com.bng.ddaja.common.hateos.licenses.Licenses;
import com.bng.ddaja.example.dto.UserDTO;
import com.bng.ddaja.example.service.UserService;
import com.bng.ddaja.test.dto.LicenseDTO;
import com.bng.ddaja.test.dto.TestParameter; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping("test")
@RestController
public class TestController {
    
    private UserService userService;
    
    @GetMapping("")
    public String test() {
        return "test";
    }

    @GetMapping("/one/{id}")
    public List<Link> one(@PathVariable(name = "id") Long id) {
        return Licenses.SELF.makeLinkList(id);
    }

    @GetMapping("/two/{id}")
    public List<Link> two(@PathVariable(name = "id") Long id) {
        return Arrays.stream(Licenses.values()).map(e -> new Link(e.name(), e.url+id.toString(), e.method)).collect(Collectors.toList());
    }

    @GetMapping("/three")
    public CommonResponse<UserDTO> three(CommonParameter parameter) {
        return userService.findUserListByParameter(parameter);        
    }

    @GetMapping("/four")
    public CommonParameter four(CommonParameter parameter) {
        return parameter;
    }

    @GetMapping("/five")
    public ResponseEntity<CommonResponse<UserDTO>> five() {
        UserDTO userDTO = new UserDTO(Integer.toUnsignedLong(11), "test", "김텟트");
        CommonResponse<UserDTO> response = new CommonResponse<UserDTO>(1, new CommonResource<UserDTO>(userDTO, null));
        return new ResponseEntity<>(response, null, HttpStatus.OK);
    }

    @GetMapping("/six")
    public ResponseEntity<CommonError> six() {
        List<CommonErrorDetail> errorDetailList = new LinkedList<>();
        errorDetailList.add(new CommonErrorDetail("parameter", "pqge=1", "notCorrectParam"));
        CommonError error = new CommonError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), errorDetailList);
        return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/seven")
    public String seven() throws MemberNotFoundException {
        throw new MemberNotFoundException();
    }

    @PostMapping("/ten")
    public ResponseEntity<String> ten(@Valid @RequestBody TestParameter parameter ) {
        return ResponseEntity.ok().body("body success");
    }

    @GetMapping("/vue")
    public ResponseEntity<CommonResponse<LicenseDTO>> vue() {
        LicenseDTO dtoOne = new LicenseDTO(11, "정보처리기사");
        LicenseDTO dtoTwo = new LicenseDTO(21, "정보처리산업기사");
        LicenseDTO dtoThr = new LicenseDTO(31, "컴퓨터활용능력 1급");
        LicenseDTO dtoFour = new LicenseDTO(41, "컴퓨터활용능력 2급");
        LicenseDTO dtoFive = new LicenseDTO(51, "빅데이터 기사");
        List<CommonResource<LicenseDTO>> dtoList = new LinkedList<>();
        dtoList.add(new CommonResource<LicenseDTO>(dtoOne, null));
        dtoList.add(new CommonResource<LicenseDTO>(dtoTwo, null));
        dtoList.add(new CommonResource<LicenseDTO>(dtoThr, null));
        dtoList.add(new CommonResource<LicenseDTO>(dtoFour, null));
        dtoList.add(new CommonResource<LicenseDTO>(dtoFive, null));
        
        return ResponseEntity.ok().body(new CommonResponse<>(dtoList.size(), dtoList));
    }
}
