package com.becenquiry.aakash.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becenquiry.aakash.dto.request.CourseRequest;
import com.becenquiry.aakash.dto.request.EnquiryRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.CourseResponse;
import com.becenquiry.aakash.dto.response.EnquiryResponse;
import com.becenquiry.aakash.repository.EnquiryRepository;
import com.becenquiry.aakash.service.EnquiryService;
import com.becenquiry.aakash.util.MyConstant;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(MyConstant.USER)
@RequiredArgsConstructor
public class EnquiryController {

    private final EnquiryService enquiryService;
    private final EnquiryRepository enquiryRepository;

        @GetMapping(MyConstant.GETENQUIRY)
    public ResponseEntity<BasicResponse<EnquiryResponse>> getAllUser(){
        BasicResponse<EnquiryResponse> response=new BasicResponse<>();
        try{
            response=enquiryService.getEnUser();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception exception){
            response.setMessage("Something Went Wrong");
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
        }
    }


    @PostMapping(MyConstant.POSTENQUIRY)
    public ResponseEntity<BasicResponse<EnquiryResponse>> createEnquiry(@RequestBody EnquiryRequest courseRequest) {
        BasicResponse<EnquiryResponse> response = new BasicResponse<>();
        try {
            BasicResponse<EnquiryResponse> createdcourse = enquiryService.createEnquiry(courseRequest);
            response.setMessage(createdcourse.getMessage());
            response.setData(createdcourse.getData());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Failed to create Enquiry: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(MyConstant.POSTENQUIRY + "/{courseId}")
    public ResponseEntity<BasicResponse<EnquiryResponse>> deleteEnquiry(@PathVariable String courseId) {
        BasicResponse<EnquiryResponse> response = new BasicResponse<>();
        try {
            BasicResponse<EnquiryResponse> deletedBookingResponse = enquiryService.deleteEnquiry(courseId);
            response.setMessage(deletedBookingResponse.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Failed to delete enquiry " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(MyConstant.POSTENQUIRY + "/{courseId}")
    public ResponseEntity<BasicResponse<EnquiryResponse>> updateCourse(@PathVariable String courseId, @RequestBody EnquiryRequest courseRequest) {
        BasicResponse<EnquiryResponse> response = new BasicResponse<>();
        try {
            BasicResponse<EnquiryResponse> updatedCourse = enquiryService.updateCourse(courseId, courseRequest);
            response.setMessage(updatedCourse.getMessage());
            response.setData(updatedCourse.getData());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Failed to update course: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
