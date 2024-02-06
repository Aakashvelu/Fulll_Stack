package com.becenquiry.aakash.service;

import com.becenquiry.aakash.dto.request.CourseRequest;
import com.becenquiry.aakash.dto.request.Loginrequest;
import com.becenquiry.aakash.dto.request.RegisterRequest;
import com.becenquiry.aakash.dto.response.CourseResponse;
import com.becenquiry.aakash.dto.response.LoginResponse;
import com.becenquiry.aakash.dto.response.RegisterResponse;

public interface AuthenticationService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(Loginrequest request);

    CourseResponse course(CourseRequest request);

}
