package com.becenquiry.aakash.controller;

import static com.becenquiry.aakash.util.MyConstant.*;
import static org.springframework.http.HttpStatus.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becenquiry.aakash.dto.request.Loginrequest;
import com.becenquiry.aakash.dto.request.RegisterRequest;
import com.becenquiry.aakash.dto.response.LoginResponse;
import com.becenquiry.aakash.dto.response.RegisterResponse;
import com.becenquiry.aakash.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        RegisterResponse response = new RegisterResponse();
        try{
            response = authenticationService.register(request);
            return new ResponseEntity<>(response,ACCEPTED);
        }
        catch(Exception e){
            response.setMessage("Something went wrong");
            return new ResponseEntity<>(response, EXPECTATION_FAILED);
        }
    }
    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponse> login(@RequestBody Loginrequest request){
        LoginResponse response = new LoginResponse();
        try{
            response = authenticationService.login(request);
            return new ResponseEntity<>(response, ACCEPTED);
        }
        catch(Exception e){
            System.out.print(e);
            response.setMessage("Someting wrong");
            response.setToken("");
            // response.builder()
            // .message("Somethin went wrong").token("").build();
            return new  ResponseEntity<>(response, EXPECTATION_FAILED);
        }
    }
}
