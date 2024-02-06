package com.becenquiry.aakash.util;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpMethod.*;

import java.util.Arrays;
import java.util.List;

public class MyConstant {
    public static final String AUTH = "api/v1/auth";
    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";
    public static final String COURSE="/course";
    public static final List<String> ORIGINS = Arrays.asList("http://localhost:4000");
    public static final List<String> Headers = Arrays.asList(AUTHORIZATION, CONTENT_TYPE);
    public static final List<String> METHODS = Arrays.asList(GET.name(), POST.name(), PUT.name(),
                DELETE.name(), HEAD.name(), PATCH.name());
}
