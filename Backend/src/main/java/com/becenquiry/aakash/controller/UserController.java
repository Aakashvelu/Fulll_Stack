package com.becenquiry.aakash.controller;


import static com.becenquiry.aakash.util.MyConstant.*;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.UserResponse;
import com.becenquiry.aakash.service.UserService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(LIST)
    public ResponseEntity<BasicResponse<UserResponse>> getAllUser(){
        BasicResponse<UserResponse> response=new BasicResponse<>();
        try{
            response=userService.getAllUser();
            return new ResponseEntity<>(response, OK);
        }
        catch(Exception exception){
            response.setMessage("Something Went Wrong");
            return new ResponseEntity<>(response,EXPECTATION_FAILED);
        }
    }
}