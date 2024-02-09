package com.becenquiry.aakash.service;

import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.UserResponse;

public interface UserService {


    BasicResponse<UserResponse> getAllUser();

}
