package com.becenquiry.aakash.controller;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becenquiry.aakash.dto.request.EnquiryRequest;
import com.becenquiry.aakash.dto.response.BasicResponse;
import com.becenquiry.aakash.dto.response.EnquiryResponse;
import com.becenquiry.aakash.service.EnquiryService;
import com.becenquiry.aakash.util.MyConstant;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(MyConstant.USER)
@RequiredArgsConstructor
public class EnquiryController {

    private final EnquiryService enquiryService;

    @GetMapping(MyConstant.GETENQUIRY)
    public ResponseEntity<BasicResponse<EnquiryResponse>> getEnquiryList(){
        BasicResponse<EnquiryResponse> response=new BasicResponse<>();
        try{
            response=enquiryService.getAllenquiry();
            return new ResponseEntity<>(response, OK);
        }
        catch(Exception exception){
            response.setMessage("Something Went Wrong");
            return new ResponseEntity<>(response,EXPECTATION_FAILED);
        }
    }

    @PostMapping(MyConstant.ENQUIRY)
    public ResponseEntity<EnquiryResponse> register(@RequestBody EnquiryRequest request) {
        EnquiryResponse response=new EnquiryResponse();

        try{
            response=enquiryService.register(request);
            return new ResponseEntity<>(response, ACCEPTED);
        }
        catch(Exception e){
            response.setMessage("Something Went Wrong!!!!");
            return new ResponseEntity<>(response, EXPECTATION_FAILED);
        }
        
    }
    @DeleteMapping(MyConstant.ENQUIRY + "/{enquiryId}")
    public ResponseEntity<BasicResponse<EnquiryResponse>> deleteEnquiry(@PathVariable String enquiryId) {
        BasicResponse<EnquiryResponse> response = new BasicResponse<>();
        try {
            BasicResponse<EnquiryResponse> deletedenquiryResponse = enquiryService.deleteEnquiry(enquiryId);
            response.setMessage(deletedenquiryResponse.getMessage());
            return new ResponseEntity<>(response, OK);
        } catch (Exception e) {
            response.setMessage("Failed to delete enquiry: " + e.getMessage());
            return new ResponseEntity<>(response, INTERNAL_SERVER_ERROR);
  }

}
}