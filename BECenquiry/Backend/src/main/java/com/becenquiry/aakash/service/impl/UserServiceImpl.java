package com.becenquiry.aakash.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.UserResponse;
import com.becenquiry.aakash.model.User;
import com.becenquiry.aakash.repository.UserRepository;
import com.becenquiry.aakash.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public BasicResponse<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream().map(user -> UserResponse.builder()
        .id(user.getId())
        .name(user.getName())
        .email(user.getEmail())
        .role(user.getRole())
        .address(user.getAddress())
        .phoneNumber(user.getPhoneNumber())
        .build())
            .collect(Collectors.toList());
        return BasicResponse.<UserResponse>builder().message("user data fetched successfully")
            .data(userResponses).build();
    }

}
