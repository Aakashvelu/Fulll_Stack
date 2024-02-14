package com.becenquiry.aakash.service;

import com.becenquiry.aakash.dto.request.CourseRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.CourseResponse;

public interface CourseService {

   

    BasicResponse<CourseResponse> getAllCourse();

    CourseResponse register(CourseRequest request);

    BasicResponse<CourseResponse> updateCourse(String courseId, CourseRequest courseRequest);

    BasicResponse<CourseResponse> deletecourse(String courseId);

}
