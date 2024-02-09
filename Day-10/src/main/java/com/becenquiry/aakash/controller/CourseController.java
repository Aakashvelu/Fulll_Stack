package com.becenquiry.aakash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.becenquiry.aakash.util.MyConstant.*;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.HttpStatus;

import com.becenquiry.aakash.dto.request.CourseRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.CourseResponse;
import com.becenquiry.aakash.repository.CourseRepository;
import com.becenquiry.aakash.service.CourseService;
import com.becenquiry.aakash.util.MyConstant;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(MyConstant.USER)
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final CourseRepository courseRepository;

        @GetMapping(GETCOURSE)
    public ResponseEntity<BasicResponse<CourseResponse>> getAllUser(){
        BasicResponse<CourseResponse> response=new BasicResponse<>();
        try{
            response=courseService.getUser();
            return new ResponseEntity<>(response, OK);
        }
        catch(Exception exception){
            response.setMessage("Something Went Wrong");
            return new ResponseEntity<>(response,EXPECTATION_FAILED);
        }
    }


    @PostMapping(MyConstant.POSTCOURSE)
    public ResponseEntity<BasicResponse<CourseResponse>> createCourse(@RequestBody CourseRequest courseRequest) {
        BasicResponse<CourseResponse> response = new BasicResponse<>();
        try {
            BasicResponse<CourseResponse> createdcourse = courseService.createCourse(courseRequest);
            response.setMessage(createdcourse.getMessage());
            response.setData(createdcourse.getData());
            return new ResponseEntity<>(response, OK);
        } catch (Exception e) {
            response.setMessage("Failed to create course: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(MyConstant.POSTCOURSE + "/{courseId}")
    public ResponseEntity<BasicResponse<CourseResponse>> deleteCourse(@PathVariable String courseId) {
        BasicResponse<CourseResponse> response = new BasicResponse<>();
        try {
            BasicResponse<CourseResponse> deletedBookingResponse = courseService.deleteCourse(courseId);
            response.setMessage(deletedBookingResponse.getMessage());
            return new ResponseEntity<>(response, OK);
        } catch (Exception e) {
            response.setMessage("Failed to delete course: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(MyConstant.POSTCOURSE + "/{courseId}")
    public ResponseEntity<BasicResponse<CourseResponse>> updateCourse(@PathVariable String courseId, @RequestBody CourseRequest courseRequest) {
        BasicResponse<CourseResponse> response = new BasicResponse<>();
        try {
            BasicResponse<CourseResponse> updatedCourse = courseService.updateCourse(courseId, courseRequest);
            response.setMessage(updatedCourse.getMessage());
            response.setData(updatedCourse.getData());
            return new ResponseEntity<>(response, OK);
        } catch (Exception e) {
            response.setMessage("Failed to update course: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
