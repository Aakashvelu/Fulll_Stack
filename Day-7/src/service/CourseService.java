package com.becenquiry.aakash.service;

import com.becenquiry.aakash.dto.request.CourseRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.CourseResponse;

public interface CourseService {

    BasicResponse<CourseResponse> getUser();

    BasicResponse<CourseResponse> createCourse(CourseRequest courseRequest);

    BasicResponse<CourseResponse> deleteCourse(String courseId);

    BasicResponse<CourseResponse> updateCourse(String courseId, CourseRequest courseRequest);

    BasicResponse<CourseResponse> createBooking(CourseRequest courseRequest);

}
